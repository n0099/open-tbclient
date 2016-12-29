package com.baidu.tieba.personPolymeric.event;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.personPolymeric.b.ab;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.e.a {
    private ab esN;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void c(ab abVar) {
        this.esN = abVar;
    }

    @Override // com.baidu.tieba.e.a, com.baidu.tieba.view.m
    public void a(View view, com.baidu.tieba.e.b bVar) {
        int i;
        int i2;
        String str = null;
        super.a(view, bVar);
        if (bVar != null) {
            UserData userData = bVar.bso != null ? (UserData) bVar.bso.getSerializable(UserData.TYPE_USER) : null;
            switch (bVar.bsn) {
                case 1:
                    if (userData != null) {
                        l lVar = new l();
                        lVar.ff(userData.getPortraitH());
                        lVar.fg(userData.getPortrait());
                        lVar.bv(true);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(lVar);
                        this.esN.aPN().a((v) lVar, (List<v>) arrayList, 0);
                        return;
                    }
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    return;
                case 8:
                    this.GO.getPageActivity().finish();
                    return;
                case 9:
                    if (this.esN != null && this.esN.aPO() != null) {
                        this.esN.aPO().aPD();
                        return;
                    }
                    return;
                case 10:
                    String str2 = "";
                    if (userData != null) {
                        String userId = userData.getUserId();
                        str = userData.getBg_pic();
                        try {
                            i = com.baidu.adp.lib.h.b.g(oC(str).get("props_id"), -1);
                            str2 = userId;
                        } catch (URISyntaxException e) {
                            i = -1;
                            str2 = userId;
                        }
                    } else {
                        i = -1;
                    }
                    if (i == -1 || str2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(this.GO.getPageActivity())));
                        return;
                    }
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        if (StringUtils.isNull(str) || StringUtils.isNull(currentAccountInfo.getPersonalBgUrl())) {
                            i2 = 0;
                        } else if (str.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) {
                            i2 = 1;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.GO.getPageActivity(), i, i2)));
                        return;
                    }
                    i2 = 0;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(this.GO.getPageActivity(), i, i2)));
                    return;
                case 11:
                    if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        PersonChangeData personChangeData = new PersonChangeData();
                        if (userData != null) {
                            personChangeData.setPortrait(userData.getPortrait());
                            personChangeData.setName(userData.getUserName());
                            personChangeData.setSex(userData.getSex());
                            personChangeData.setIntro(userData.getIntro());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonChangeActivityConfig(this.GO.getPageActivity(), 101, personChangeData, false)));
                        return;
                    }
                    return;
                case 12:
                    TiebaStatic.log("igift_icon_ck");
                    if (bh.ai(this.GO.getPageActivity())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.GO.getPageActivity(), userData.getUserIdLong(), userData.getUserName(), GiftTabActivityConfig.FROM_PERSON_CENTER, 24001)));
                        return;
                    }
                    return;
                case 13:
                    bc.vz().c(this.GO, new String[]{TbConfig.WEB_URL_FANS});
                    return;
            }
        }
    }

    private Map<String, String> oC(final String str) throws URISyntaxException {
        return new HashMap<String, String>(str) { // from class: com.baidu.tieba.personPolymeric.event.PersonPolymericEventController$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }
}
