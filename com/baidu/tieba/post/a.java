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
    private static com.baidu.adp.widget.ImageView.a gqk;
    private static String gql;
    public TextView aEH;
    public TextView aFZ;
    public TextView aFu;
    public HeadImageView dTf;
    private final LinearLayout fzb;
    protected final LinearLayout gqh;
    protected final ColumnLayout gqi;
    protected final ColumnLayout gqj;
    private int gqm;
    public LinearLayout gqn;
    public TextView gqo;
    private InterfaceC0260a gxD;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0260a {
        void bJ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gqn = (LinearLayout) view.findViewById(e.g.top_line);
        this.dTf = (HeadImageView) view.findViewById(e.g.portrait);
        this.aFZ = (TextView) view.findViewById(e.g.username);
        this.aEH = (TextView) view.findViewById(e.g.reply_time);
        this.aFu = (TextView) view.findViewById(e.g.forum_name);
        this.gqo = (TextView) view.findViewById(e.g.reply_count);
        this.fzb = (LinearLayout) view.findViewById(e.g.item_content);
        this.gqi = (ColumnLayout) view.findViewById(e.g.item_header);
        this.gqj = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(e.g.person_thread);
        this.gqh = (LinearLayout) view.findViewById(e.g.person_child);
        this.gqm = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fzb != null) {
            this.fzb.setOnClickListener(this);
        }
        this.dTf.setOnClickListener(this);
        this.aFZ.setOnClickListener(this);
        this.aFu.setOnClickListener(this);
        this.gqo.setOnClickListener(this);
        this.gqi.setOnClickListener(this);
        this.gqj.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gxD != null) {
            this.gxD.bJ(view);
        }
    }

    public void a(InterfaceC0260a interfaceC0260a) {
        this.gxD = interfaceC0260a;
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
                str3 = ao.C(postInfoList.create_time * 1000);
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
                str3 = ao.C(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.aFZ.setText(str2);
            this.aEH.setText(str3);
            this.aFu.setText(str4);
            this.aFu.setTag(str4);
            this.gqo.setText(str5);
            this.aFu.setOnClickListener(this);
            th(str);
            if (this.fzb != null) {
                this.fzb.setTag(strArr);
            }
            this.gqi.setTag(strArr);
            this.gqj.setTag(strArr);
        }
    }

    private void th(String str) {
        if (gql != null && !gql.equals(str)) {
            gqk = null;
        }
        if (gqk != null) {
            this.dTf.setImageBitmap(gqk.os());
            gql = str;
            return;
        }
        this.dTf.startLoad(str, 12, this.gqm, this.gqm, false);
    }

    public void dW(int i) {
        al.c(this.aFu, e.d.cp_cont_d, 1);
        al.c(this.aEH, e.d.cp_cont_d, 1);
        al.c(this.aFZ, e.d.cp_cont_f, 1);
        al.i(this.mLayout, e.d.cp_bg_line_c);
        al.i(this.gqh, e.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.gqo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.gqo, e.d.cp_link_tip_c, 1);
    }
}
