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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a gbb;
    private static String gbc;
    public TextView axj;
    public TextView ayV;
    public TextView ayf;
    public TextView eXF;
    private final LinearLayout fjU;
    protected final LinearLayout gaY;
    protected final ColumnLayout gaZ;
    protected final ColumnLayout gba;
    private int gbd;
    public LinearLayout gbe;
    public HeadImageView gbf;
    private InterfaceC0221a gik;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0221a {
        void bt(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.gbe = (LinearLayout) view.findViewById(d.g.top_line);
        this.gbf = (HeadImageView) view.findViewById(d.g.portrait);
        this.ayf = (TextView) view.findViewById(d.g.username);
        this.axj = (TextView) view.findViewById(d.g.reply_time);
        this.ayV = (TextView) view.findViewById(d.g.forum_name);
        this.eXF = (TextView) view.findViewById(d.g.reply_count);
        this.fjU = (LinearLayout) view.findViewById(d.g.item_content);
        this.gaZ = (ColumnLayout) view.findViewById(d.g.item_header);
        this.gba = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.gaY = (LinearLayout) view.findViewById(d.g.person_child);
        this.gbd = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.fjU != null) {
            this.fjU.setOnClickListener(this);
        }
        this.gbf.setOnClickListener(this);
        this.ayf.setOnClickListener(this);
        this.ayV.setOnClickListener(this);
        this.eXF.setOnClickListener(this);
        this.gaZ.setOnClickListener(this);
        this.gba.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.gik != null) {
            this.gik.bt(view);
        }
    }

    public void a(InterfaceC0221a interfaceC0221a) {
        this.gik = interfaceC0221a;
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
                str3 = ap.w(postInfoList.create_time * 1000);
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
                str3 = ap.w(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.ayf.setText(str2);
            this.axj.setText(str3);
            this.ayV.setText(str4);
            this.ayV.setTag(str4);
            this.eXF.setText(str5);
            this.ayV.setOnClickListener(this);
            sd(str);
            if (this.fjU != null) {
                this.fjU.setTag(strArr);
            }
            this.gaZ.setTag(strArr);
            this.gba.setTag(strArr);
        }
    }

    private void sd(String str) {
        if (gbc != null && !gbc.equals(str)) {
            gbb = null;
        }
        if (gbb != null) {
            this.gbf.setImageBitmap(gbb.mZ());
            gbc = str;
            return;
        }
        this.gbf.startLoad(str, 12, this.gbd, this.gbd, false);
    }

    public void dz(int i) {
        am.c(this.ayV, d.C0142d.cp_cont_d, 1);
        am.c(this.axj, d.C0142d.cp_cont_d, 1);
        am.c(this.ayf, d.C0142d.cp_cont_f, 1);
        am.i(this.mLayout, d.C0142d.cp_bg_line_c);
        am.i(this.gaY, d.f.daily_recommend_item_selector);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.eXF.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.c(this.eXF, d.C0142d.cp_link_tip_c, 1);
    }
}
