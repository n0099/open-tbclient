package com.baidu.tieba.pb.pb.main.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a {
    private static final String ggk = d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private final com.baidu.tieba.pb.pb.a ggl;
    public final View.OnClickListener eig = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.1
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
                if (ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    str3 = userId;
                } else {
                    am amVar = new am("c13267");
                    amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
                    amVar.aA(ImageViewerConfig.FORUM_ID, fid);
                    amVar.aA("tid", tid);
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(amVar);
                    str3 = userId;
                }
            } else {
                if (view.getTag(e.g.tag_user_id) instanceof String) {
                    str = (String) view.getTag(e.g.tag_user_id);
                } else {
                    str = view.getTag() instanceof String ? (String) view.getTag() : null;
                }
                if (view.getTag(e.g.tag_user_name) instanceof String) {
                    str2 = (String) view.getTag(e.g.tag_user_name);
                    str3 = str;
                } else {
                    str2 = null;
                    str3 = str;
                }
            }
            if (view.getTag(e.g.tag_nick_name_activity) != null && (view.getTag(e.g.tag_nick_name_activity) instanceof String)) {
                String str4 = (String) view.getTag(e.g.tag_nick_name_activity);
                if (!TextUtils.isEmpty(str4) && ba.bJ(TbadkCoreApplication.getInst())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(a.this.ggl.getPageContext().getPageActivity(), null, str4, true)));
                    return;
                }
            }
            String str5 = view.getTag(e.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(e.g.tag_virtual_user_url) : null;
            if (str5 != null) {
                if (ba.bJ(TbadkCoreApplication.getInst())) {
                    ay.Ef().c(a.this.ggl.getPageContext(), new String[]{str5});
                }
            } else if (str3 != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(a.this.ggl.getPageContext().getPageActivity(), str3, str2, a.this.ggl.bhf(), AddFriendActivityConfig.TYPE_PB_HEAD)));
            }
        }
    };
    public final View.OnClickListener ggm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag(e.g.tag_user_id) instanceof String) {
                com.baidu.tbadk.browser.a.a(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(e.j.user_icon_web_view_title), a.ggk + "?user_id=" + ((String) view.getTag(e.g.tag_user_id)), true, true, true);
                TiebaStatic.log(new am("c10134").x("obj_type", 2));
            }
        }
    };
    public final View.OnClickListener ggn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.b.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ba.bJ(TbadkCoreApplication.getInst())) {
                String str = null;
                if (view.getTag() != null) {
                    str = (String) view.getTag();
                }
                if (str != null) {
                    ay.Ef().c(a.this.ggl.getPageContext(), new String[]{str});
                }
                TiebaStatic.eventStat(a.this.ggl.getPageContext().getPageActivity(), "consume_2", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        }
    };
    public final TbRichTextView.g ggo = new TbRichTextView.g() { // from class: com.baidu.tieba.pb.pb.main.b.a.4
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.g
        public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(a.this.ggl.getPageContext().getPageActivity(), str, str2, str3, str4, str5, str6, 1, i, i2)));
        }
    };

    public a(com.baidu.tieba.pb.pb.a aVar) {
        this.ggl = aVar;
    }
}
