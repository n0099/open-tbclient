package com.baidu.tieba.personPolymeric.header;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackgroundPreviewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.PullRefreshFrameLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
/* loaded from: classes11.dex */
public class a {
    private View diZ;
    private TbImageView ksY;
    private int ksZ;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.header.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            int i2;
            if (a.this.mIsHost) {
                if (a.this.mUserData == null || !a.this.mUserData.isBaijiahaoUser()) {
                    TiebaStatic.log(new an("c12502").dh("obj_locate", "3"));
                    String userId = a.this.mUserData.getUserId();
                    String bg_pic = a.this.mUserData.getBg_pic();
                    try {
                        i = com.baidu.adp.lib.f.b.toInt((String) a.this.Kq(bg_pic).get("props_id"), -1);
                    } catch (URISyntaxException e) {
                        i = -1;
                    }
                    if (i == -1 || userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackdropGroupActivityConfig(a.this.ksY.getContext())));
                        return;
                    }
                    AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
                    if (currentAccountInfo != null) {
                        if (StringUtils.isNull(bg_pic) || StringUtils.isNull(currentAccountInfo.getPersonalBgUrl())) {
                            i2 = 0;
                        } else if (bg_pic.equalsIgnoreCase(currentAccountInfo.getPersonalBgUrl())) {
                            i2 = 1;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(a.this.ksY.getContext(), i, i2)));
                    }
                    i2 = 0;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalBackgroundPreviewActivityConfig(a.this.ksY.getContext(), i, i2)));
                }
            }
        }
    };
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private UserData mUserData;

    public a(TbPageContext tbPageContext, TbImageView tbImageView, View view, boolean z) {
        this.mPageContext = tbPageContext;
        this.ksY = tbImageView;
        this.mIsHost = z;
        this.ksY.setDefaultBgResource(R.drawable.bg_pic_mine);
        this.diZ = view;
        this.diZ.setOnClickListener(this.mClickListener);
    }

    public void e(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
            String bg_pic = this.mUserData.getBg_pic();
            if (!aq.isEmpty(bg_pic)) {
                com.baidu.adp.lib.e.c.kX().a(bg_pic, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.personPolymeric.header.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass1) aVar, str, i);
                        if (aVar != null) {
                            aVar.drawImageTo(a.this.ksY);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onProgressUpdate(Object... objArr) {
                        super.onProgressUpdate(objArr);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onCancelled(String str) {
                        super.onCancelled(str);
                    }
                }, 0, 0, this.mPageContext.getUniqueId(), new Object[0]);
            }
        }
    }

    public void Bu(int i) {
        this.ksZ = i;
        ViewGroup.LayoutParams layoutParams = this.ksY.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.ksZ;
            this.ksY.setLayoutParams(layoutParams);
        }
    }

    public void s(double d) {
        int i = (int) (this.ksZ + (PullRefreshFrameLayout.dUT * d));
        ViewGroup.LayoutParams layoutParams = this.ksY.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.ksY.setLayoutParams(layoutParams);
        }
    }

    public void Bv(int i) {
        ViewGroup.LayoutParams layoutParams = this.ksY.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            this.ksY.setLayoutParams(layoutParams);
        }
    }

    public int bVE() {
        ViewGroup.LayoutParams layoutParams = this.ksY.getLayoutParams();
        if (layoutParams != null) {
            return layoutParams.height;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> Kq(final String str) throws URISyntaxException {
        return new HashMap<String, String>() { // from class: com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(new URI(str), "UTF-8")) {
                    put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        };
    }
}
