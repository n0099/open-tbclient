package com.baidu.tieba.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a gBr;
    private static String gBs;
    public TextView aIY;
    public TextView aJM;
    public TextView aKr;
    public HeadImageView edG;
    private final LinearLayout fKh;
    protected final LinearLayout gBo;
    protected final ColumnLayout gBp;
    protected final ColumnLayout gBq;
    private int gBt;
    public LinearLayout gBu;
    public TextView gBv;
    private InterfaceC0299a gIM;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0299a {
        void bO(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gBu = (LinearLayout) view.findViewById(e.g.top_line);
        this.edG = (HeadImageView) view.findViewById(e.g.portrait);
        this.aKr = (TextView) view.findViewById(e.g.username);
        this.aIY = (TextView) view.findViewById(e.g.reply_time);
        this.aJM = (TextView) view.findViewById(e.g.forum_name);
        this.gBv = (TextView) view.findViewById(e.g.reply_count);
        this.fKh = (LinearLayout) view.findViewById(e.g.item_content);
        this.gBp = (ColumnLayout) view.findViewById(e.g.item_header);
        this.gBq = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(e.g.person_thread);
        this.gBo = (LinearLayout) view.findViewById(e.g.person_child);
        this.gBt = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fKh != null) {
            this.fKh.setOnClickListener(this);
        }
        this.edG.setOnClickListener(this);
        this.aKr.setOnClickListener(this);
        this.aJM.setOnClickListener(this);
        this.gBv.setOnClickListener(this);
        this.gBp.setOnClickListener(this);
        this.gBq.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gIM != null) {
            this.gIM.bO(view);
        }
    }

    public void a(InterfaceC0299a interfaceC0299a) {
        this.gIM = interfaceC0299a;
    }

    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        boolean z2;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String[] strArr = new String[4];
        try {
            if (z) {
                z2 = true;
                str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.post_id);
                str3 = ao.M(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
                strArr[3] = String.valueOf(postInfoList.thread_type);
            } else {
                z2 = true;
                str2 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                strArr[0] = String.valueOf(postInfoList.thread_id);
                strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                strArr[3] = String.valueOf(postInfoList.thread_type);
                str3 = ao.M(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.aKr.setText(str2);
            this.aIY.setText(str3);
            this.aJM.setText(str4);
            this.aJM.setTag(str4);
            this.gBv.setText(str5);
            this.aJM.setOnClickListener(this);
            tR(str);
            if (this.fKh != null) {
                this.fKh.setTag(strArr);
            }
            this.gBp.setTag(strArr);
            this.gBq.setTag(strArr);
        }
    }

    private void tR(String str) {
        if (gBs != null && !gBs.equals(str)) {
            gBr = null;
        }
        if (gBr != null) {
            this.edG.setImageBitmap(gBr.op());
            gBs = str;
            return;
        }
        this.edG.startLoad(str, 12, this.gBt, this.gBt, false);
    }

    public void ey(int i) {
        al.c(this.aJM, e.d.cp_cont_d, 1);
        al.c(this.aIY, e.d.cp_cont_d, 1);
        al.c(this.aKr, e.d.cp_cont_f, 1);
        al.i(this.mLayout, e.d.cp_bg_line_c);
        al.i(this.gBo, e.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.gBv.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.gBv, e.d.cp_link_tip_c, 1);
    }
}
