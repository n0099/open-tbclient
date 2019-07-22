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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a irq;
    private static String irr;
    public TextView XL;
    public TextView caZ;
    public TextView cbW;
    public HeadImageView fNK;
    private final LinearLayout hyx;
    private InterfaceC0388a iAc;
    protected final LinearLayout irn;
    protected final ColumnLayout iro;
    protected final ColumnLayout irp;
    private int irs;
    public LinearLayout irt;
    public TextView iru;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0388a {
        void cM(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.irt = (LinearLayout) view.findViewById(R.id.top_line);
        this.fNK = (HeadImageView) view.findViewById(R.id.portrait);
        this.XL = (TextView) view.findViewById(R.id.username);
        this.caZ = (TextView) view.findViewById(R.id.reply_time);
        this.cbW = (TextView) view.findViewById(R.id.forum_name);
        this.iru = (TextView) view.findViewById(R.id.reply_count);
        this.hyx = (LinearLayout) view.findViewById(R.id.item_content);
        this.iro = (ColumnLayout) view.findViewById(R.id.item_header);
        this.irp = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.irn = (LinearLayout) view.findViewById(R.id.person_child);
        this.irs = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hyx != null) {
            this.hyx.setOnClickListener(this);
        }
        this.fNK.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.cbW.setOnClickListener(this);
        this.iru.setOnClickListener(this);
        this.iro.setOnClickListener(this);
        this.irp.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.iAc != null) {
            this.iAc.cM(view);
        }
    }

    public void a(InterfaceC0388a interfaceC0388a) {
        this.iAc = interfaceC0388a;
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
                str3 = aq.aD(postInfoList.create_time * 1000);
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
                str3 = aq.aD(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.XL.setText(str2);
            this.caZ.setText(str3);
            this.cbW.setText(str4);
            this.cbW.setTag(str4);
            this.iru.setText(str5);
            this.cbW.setOnClickListener(this);
            CR(str);
            if (this.hyx != null) {
                this.hyx.setTag(strArr);
            }
            this.iro.setTag(strArr);
            this.irp.setTag(strArr);
        }
    }

    private void CR(String str) {
        if (irr != null && !irr.equals(str)) {
            irq = null;
        }
        if (irq != null) {
            this.fNK.setImageBitmap(irq.nK());
            irr = str;
            return;
        }
        this.fNK.startLoad(str, 12, this.irs, this.irs, false);
    }

    public void iV(int i) {
        am.f(this.cbW, R.color.cp_cont_d, 1);
        am.f(this.caZ, R.color.cp_cont_d, 1);
        am.f(this.XL, R.color.cp_cont_f, 1);
        am.k(this.mLayout, R.color.cp_bg_line_c);
        am.k(this.irn, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.iru.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.f(this.iru, R.color.cp_link_tip_c, 1);
    }
}
