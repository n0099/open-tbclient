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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a hSv;
    private static String hSw;
    public TextView Zy;
    public TextView bSY;
    public TextView bSb;
    public HeadImageView fsC;
    protected final LinearLayout hSs;
    protected final ColumnLayout hSt;
    protected final ColumnLayout hSu;
    private int hSx;
    public LinearLayout hSy;
    public TextView hSz;
    private final LinearLayout hbc;
    private InterfaceC0370a ibq;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0370a {
        void cB(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.hSy = (LinearLayout) view.findViewById(d.g.top_line);
        this.fsC = (HeadImageView) view.findViewById(d.g.portrait);
        this.Zy = (TextView) view.findViewById(d.g.username);
        this.bSb = (TextView) view.findViewById(d.g.reply_time);
        this.bSY = (TextView) view.findViewById(d.g.forum_name);
        this.hSz = (TextView) view.findViewById(d.g.reply_count);
        this.hbc = (LinearLayout) view.findViewById(d.g.item_content);
        this.hSt = (ColumnLayout) view.findViewById(d.g.item_header);
        this.hSu = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.hSs = (LinearLayout) view.findViewById(d.g.person_child);
        this.hSx = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hbc != null) {
            this.hbc.setOnClickListener(this);
        }
        this.fsC.setOnClickListener(this);
        this.Zy.setOnClickListener(this);
        this.bSY.setOnClickListener(this);
        this.hSz.setOnClickListener(this);
        this.hSt.setOnClickListener(this);
        this.hSu.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.ibq != null) {
            this.ibq.cB(view);
        }
    }

    public void a(InterfaceC0370a interfaceC0370a) {
        this.ibq = interfaceC0370a;
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
                str3 = ap.ao(postInfoList.create_time * 1000);
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
                str3 = ap.ao(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.Zy.setText(str2);
            this.bSb.setText(str3);
            this.bSY.setText(str4);
            this.bSY.setTag(str4);
            this.hSz.setText(str5);
            this.bSY.setOnClickListener(this);
            AL(str);
            if (this.hbc != null) {
                this.hbc.setTag(strArr);
            }
            this.hSt.setTag(strArr);
            this.hSu.setTag(strArr);
        }
    }

    private void AL(String str) {
        if (hSw != null && !hSw.equals(str)) {
            hSv = null;
        }
        if (hSv != null) {
            this.fsC.setImageBitmap(hSv.oy());
            hSw = str;
            return;
        }
        this.fsC.startLoad(str, 12, this.hSx, this.hSx, false);
    }

    public void ic(int i) {
        al.d(this.bSY, d.C0277d.cp_cont_d, 1);
        al.d(this.bSb, d.C0277d.cp_cont_d, 1);
        al.d(this.Zy, d.C0277d.cp_cont_f, 1);
        al.k(this.mLayout, d.C0277d.cp_bg_line_c);
        al.k(this.hSs, d.C0277d.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.hSz.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        al.d(this.hSz, d.C0277d.cp_link_tip_c, 1);
    }
}
