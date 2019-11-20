package com.baidu.tieba.pb.pb.main.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {
    private static final String USER_ICON_WEBVIEW = d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW;
    private final com.baidu.tieba.pb.pb.a hYB;
    public final View.OnClickListener fXf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            if (view instanceof HeadImageView) {
                String userId = ((HeadImageView) view).getUserId();
                str2 = ((HeadImageView) view).getUserName();
                String fid = ((HeadImageView) view).getFid();
                String tid = ((HeadImageView) view).getTid();
                if (aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    str3 = userId;
                } else {
                    an anVar = new an("c13267");
                    anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.bS("fid", fid);
                    anVar.bS("tid", tid);
                    anVar.bS("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar);
                    str3 = userId;
                }
            } else {
                if (view.getTag(R.id.tag_user_id) instanceof String) {
                    str = (String) view.getTag(R.id.tag_user_id);
                } else {
                    str = view.getTag() instanceof String ? (String) view.getTag() : null;
                }
                if (view.getTag(R.id.tag_user_name) instanceof String) {
                    str2 = (String) view.getTag(R.id.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (view.getTag(R.id.tag_statistic_item) instanceof an) {
                TiebaStatic.log((an) view.getTag(R.id.tag_statistic_item));
            }
            if (view.getTag(R.id.tag_nick_name_activity) != null && (view.getTag(R.id.tag_nick_name_activity) instanceof String)) {
                String str4 = (String) view.getTag(R.id.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str4) && bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(a.this.hYB.getPageContext().getPageActivity(), null, str4, true)));
                    return;
                }
            }
            String str5 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
            if (str5 != null) {
                if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                    ba.amO().b(a.this.hYB.getPageContext(), new String[]{str5});
                }
            } else if (str3 != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.hYB.getPageContext().getPageActivity(), str3, str2, a.this.hYB.bRu(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    };
    public final View.OnClickListener hYC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(R.id.tag_user_id) instanceof String) {
                com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), a.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).O("obj_type", 2));
            }
        }
    };
    public final View.OnClickListener hYD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                String str = null;
                if (view.getTag() != null) {
                    str = (String) view.getTag();
                }
                if (str != null) {
                    ba.amO().b(a.this.hYB.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(a.this.hYB.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
            }
        }
    };
    public final TbRichTextView.g hYE = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.main.b.a.4
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(a.this.hYB.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };

    public a(com.baidu.tieba.pb.pb.a aVar) {
        this.hYB = aVar;
    }
}
