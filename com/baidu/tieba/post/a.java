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
    private static com.baidu.adp.widget.ImageView.a isu;
    private static String isv;
    public TextView XL;
    public TextView cbg;
    public TextView ccd;
    public HeadImageView fOy;
    private final LinearLayout hzp;
    private InterfaceC0394a iBg;
    protected final LinearLayout isr;
    protected final ColumnLayout iss;
    protected final ColumnLayout ist;
    private int isw;
    public LinearLayout isx;
    public TextView isy;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0394a {
        void cO(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.isx = (LinearLayout) view.findViewById(R.id.top_line);
        this.fOy = (HeadImageView) view.findViewById(R.id.portrait);
        this.XL = (TextView) view.findViewById(R.id.username);
        this.cbg = (TextView) view.findViewById(R.id.reply_time);
        this.ccd = (TextView) view.findViewById(R.id.forum_name);
        this.isy = (TextView) view.findViewById(R.id.reply_count);
        this.hzp = (LinearLayout) view.findViewById(R.id.item_content);
        this.iss = (ColumnLayout) view.findViewById(R.id.item_header);
        this.ist = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.isr = (LinearLayout) view.findViewById(R.id.person_child);
        this.isw = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hzp != null) {
            this.hzp.setOnClickListener(this);
        }
        this.fOy.setOnClickListener(this);
        this.XL.setOnClickListener(this);
        this.ccd.setOnClickListener(this);
        this.isy.setOnClickListener(this);
        this.iss.setOnClickListener(this);
        this.ist.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.iBg != null) {
            this.iBg.cO(view);
        }
    }

    public void a(InterfaceC0394a interfaceC0394a) {
        this.iBg = interfaceC0394a;
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
            this.cbg.setText(str3);
            this.ccd.setText(str4);
            this.ccd.setTag(str4);
            this.isy.setText(str5);
            this.ccd.setOnClickListener(this);
            CS(str);
            if (this.hzp != null) {
                this.hzp.setTag(strArr);
            }
            this.iss.setTag(strArr);
            this.ist.setTag(strArr);
        }
    }

    private void CS(String str) {
        if (isv != null && !isv.equals(str)) {
            isu = null;
        }
        if (isu != null) {
            this.fOy.setImageBitmap(isu.nK());
            isv = str;
            return;
        }
        this.fOy.startLoad(str, 12, this.isw, this.isw, false);
    }

    public void iV(int i) {
        am.f(this.ccd, R.color.cp_cont_d, 1);
        am.f(this.cbg, R.color.cp_cont_d, 1);
        am.f(this.XL, R.color.cp_cont_f, 1);
        am.k(this.mLayout, R.color.cp_bg_line_c);
        am.k(this.isr, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.isy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.f(this.isy, R.color.cp_link_tip_c, 1);
    }
}
