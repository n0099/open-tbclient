package com.baidu.tieba.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private static com.baidu.adp.widget.ImageView.a isd;
    private static String ise;
    public TextView He;
    public TextView cpw;
    public TextView cqt;
    public HeadImageView fOR;
    private final LinearLayout hzd;
    private InterfaceC0499a iBd;
    protected final LinearLayout isa;
    protected final ColumnLayout isb;
    protected final ColumnLayout isc;
    private int isf;
    public LinearLayout isg;
    public TextView ish;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0499a {
        void cK(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.isg = (LinearLayout) view.findViewById(R.id.top_line);
        this.fOR = (HeadImageView) view.findViewById(R.id.portrait);
        this.He = (TextView) view.findViewById(R.id.username);
        this.cpw = (TextView) view.findViewById(R.id.reply_time);
        this.cqt = (TextView) view.findViewById(R.id.forum_name);
        this.ish = (TextView) view.findViewById(R.id.reply_count);
        this.hzd = (LinearLayout) view.findViewById(R.id.item_content);
        this.isb = (ColumnLayout) view.findViewById(R.id.item_header);
        this.isc = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(R.id.person_thread);
        this.isa = (LinearLayout) view.findViewById(R.id.person_child);
        this.isf = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.hzd != null) {
            this.hzd.setOnClickListener(this);
        }
        this.fOR.setOnClickListener(this);
        this.He.setOnClickListener(this);
        this.cqt.setOnClickListener(this);
        this.ish.setOnClickListener(this);
        this.isb.setOnClickListener(this);
        this.isc.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.iBd != null) {
            this.iBd.cK(view);
        }
    }

    public void a(InterfaceC0499a interfaceC0499a) {
        this.iBd = interfaceC0499a;
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
                str3 = aq.getFormatTime(postInfoList.create_time * 1000);
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
                str3 = aq.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.He.setText(str2);
            this.cpw.setText(str3);
            this.cqt.setText(str4);
            this.cqt.setTag(str4);
            this.ish.setText(str5);
            this.cqt.setOnClickListener(this);
            BK(str);
            if (this.hzd != null) {
                this.hzd.setTag(strArr);
            }
            this.isb.setTag(strArr);
            this.isc.setTag(strArr);
        }
    }

    private void BK(String str) {
        if (ise != null && !ise.equals(str)) {
            isd = null;
        }
        if (isd != null) {
            this.fOR.setImageBitmap(isd.getRawBitmap());
            ise = str;
            return;
        }
        this.fOR.a(str, 12, this.isf, this.isf, false);
    }

    public void changeSkin(int i) {
        am.setViewTextColor(this.cqt, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.cpw, R.color.cp_cont_d, 1);
        am.setViewTextColor(this.He, R.color.cp_cont_f, 1);
        am.setBackgroundResource(this.mLayout, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.isa, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.ish.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.ish, R.color.cp_link_tip_c, 1);
    }
}
