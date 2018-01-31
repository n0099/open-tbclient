package com.baidu.tieba.pb.pb.main.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    private static final String fUM = d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private final PbActivity fJR;
    public final View.OnClickListener fUN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            if (view instanceof HeadImageView) {
                String userId = ((HeadImageView) view).getUserId();
                str2 = ((HeadImageView) view).getUserName();
                str3 = userId;
            } else {
                if (view.getTag(d.g.tag_user_id) instanceof String) {
                    str = (String) view.getTag(d.g.tag_user_id);
                } else {
                    str = view.getTag() instanceof String ? (String) view.getTag() : null;
                }
                if (view.getTag(d.g.tag_user_name) instanceof String) {
                    str2 = (String) view.getTag(d.g.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                String str4 = (String) view.getTag(d.g.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str4) && a.this.fJR.checkUpIsLogin()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(a.this.fJR.getPageContext().getPageActivity(), null, str4, true)));
                    return;
                }
            }
            String str5 = view.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(d.g.tag_virtual_user_url) : null;
            if (str5 != null) {
                if (a.this.fJR.checkUpIsLogin()) {
                    av.Da().c(a.this.fJR.getPageContext(), new String[]{str5});
                }
            } else if (str3 != null && a.this.fJR.aZT() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(a.this.fJR.getPageContext().getPageActivity(), str3, str2, a.this.fJR.aZT().bbJ(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    };
    public final View.OnClickListener fUO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(d.g.tag_user_id) instanceof String) {
                com.baidu.tbadk.browser.a.a(a.this.fJR.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.j.user_icon_web_view_title), a.fUM + "?user_id=" + ((String) view.getTag(d.g.tag_user_id)), true, true, true);
                TiebaStatic.log(new ak("c10134").s("obj_type", 2));
            }
        }
    };
    public final View.OnClickListener fUP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fJR.checkUpIsLogin()) {
                String str = null;
                if (view.getTag() != null) {
                    str = (String) view.getTag();
                }
                if (ax.bb(a.this.fJR.getActivity()) && str != null) {
                    av.Da().c(a.this.fJR.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(a.this.fJR.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
            }
        }
    };
    public final TbRichTextView.g fUQ = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.main.a.a.4
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            a.this.fJR.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(a.this.fJR.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };

    public a(PbActivity pbActivity) {
        this.fJR = pbActivity;
    }
}
