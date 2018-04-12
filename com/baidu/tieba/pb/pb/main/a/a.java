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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    private static final String fsj = d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private final PbActivity fgM;
    public final View.OnClickListener fsk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            if (view2 instanceof HeadImageView) {
                String userId = ((HeadImageView) view2).getUserId();
                str2 = ((HeadImageView) view2).getUserName();
                str3 = userId;
            } else {
                if (view2.getTag(d.g.tag_user_id) instanceof String) {
                    str = (String) view2.getTag(d.g.tag_user_id);
                } else {
                    str = view2.getTag() instanceof String ? (String) view2.getTag() : null;
                }
                if (view2.getTag(d.g.tag_user_name) instanceof String) {
                    str2 = (String) view2.getTag(d.g.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (view2.getTag(d.g.tag_nick_name_activity) != null && (view2.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                String str4 = (String) view2.getTag(d.g.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str4) && a.this.fgM.checkUpIsLogin()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.fgM.getPageContext().getPageActivity(), null, str4, true)));
                    return;
                }
            }
            String str5 = view2.getTag(d.g.tag_virtual_user_url) instanceof String ? (String) view2.getTag(d.g.tag_virtual_user_url) : null;
            if (str5 != null) {
                if (a.this.fgM.checkUpIsLogin()) {
                    ax.wg().c(a.this.fgM.getPageContext(), new String[]{str5});
                }
            } else if (str3 != null && a.this.fgM.aWx() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(a.this.fgM.getPageContext().getPageActivity(), str3, str2, a.this.fgM.aWx().aYi(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    };
    public final View.OnClickListener fsl = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getTag(d.g.tag_user_id) instanceof String) {
                com.baidu.tbadk.browser.a.a(a.this.fgM.getApplicationContext(), TbadkCoreApplication.getInst().getString(d.k.user_icon_web_view_title), a.fsj + "?user_id=" + ((String) view2.getTag(d.g.tag_user_id)), true, true, true);
                TiebaStatic.log(new al("c10134").r("obj_type", 2));
            }
        }
    };
    public final View.OnClickListener fsm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (a.this.fgM.checkUpIsLogin()) {
                String str = null;
                if (view2.getTag() != null) {
                    str = (String) view2.getTag();
                }
                if (az.aK(a.this.fgM.getActivity()) && str != null) {
                    ax.wg().c(a.this.fgM.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(a.this.fgM.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
            }
        }
    };
    public final TbRichTextView.g fsn = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.main.a.a.4
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
        public void a(View view2, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            a.this.fgM.sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(a.this.fgM.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };

    public a(PbActivity pbActivity) {
        this.fgM = pbActivity;
    }
}
