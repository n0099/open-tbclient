package com.baidu.tieba.pb.pb.main.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes2.dex */
public class a {
    private static final String fIN = d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    public final View.OnClickListener fIO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.1
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
                String fid = ((HeadImageView) view).getFid();
                String tid = ((HeadImageView) view).getTid();
                if (ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    str3 = userId;
                } else {
                    an anVar = new an("c13267");
                    anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.ae(ImageViewerConfig.FORUM_ID, fid);
                    anVar.ae("tid", tid);
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar);
                    str3 = userId;
                }
            } else {
                if (view.getTag(f.g.tag_user_id) instanceof String) {
                    str = (String) view.getTag(f.g.tag_user_id);
                } else {
                    str = view.getTag() instanceof String ? (String) view.getTag() : null;
                }
                if (view.getTag(f.g.tag_user_name) instanceof String) {
                    str2 = (String) view.getTag(f.g.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (view.getTag(f.g.tag_nick_name_activity) != null && (view.getTag(f.g.tag_nick_name_activity) instanceof String)) {
                String str4 = (String) view.getTag(f.g.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str4) && a.this.fxm.checkUpIsLogin()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.fxm.getPageContext().getPageActivity(), null, str4, true)));
                    return;
                }
            }
            String str5 = view.getTag(f.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(f.g.tag_virtual_user_url) : null;
            if (str5 != null) {
                if (a.this.fxm.checkUpIsLogin()) {
                    az.zI().c(a.this.fxm.getPageContext(), new String[]{str5});
                }
            } else if (str3 != null && a.this.fxm.bao() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(a.this.fxm.getPageContext().getPageActivity(), str3, str2, a.this.fxm.bao().bcc(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    };
    public final View.OnClickListener fIP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(f.g.tag_user_id) instanceof String) {
                com.baidu.tbadk.browser.a.a(a.this.fxm.getApplicationContext(), TbadkCoreApplication.getInst().getString(f.j.user_icon_web_view_title), a.fIN + "?user_id=" + ((String) view.getTag(f.g.tag_user_id)), true, true, true);
                TiebaStatic.log(new an("c10134").r("obj_type", 2));
            }
        }
    };
    public final View.OnClickListener fIQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.a.a.3
        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fxm.checkUpIsLogin()) {
                String str = null;
                if (view.getTag() != null) {
                    str = (String) view.getTag();
                }
                if (bb.aU(a.this.fxm.getActivity()) && str != null) {
                    az.zI().c(a.this.fxm.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(a.this.fxm.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
            }
        }
    };
    public final TbRichTextView.g fIR = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.main.a.a.4
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            a.this.fxm.sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(a.this.fxm.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };
    private final PbActivity fxm;

    public a(PbActivity pbActivity) {
        this.fxm = pbActivity;
    }
}
