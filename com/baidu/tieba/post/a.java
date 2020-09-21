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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes23.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a lxb;
    private static String lxc;
    public TextView ajb;
    public TextView evD;
    public TextView ewA;
    private final LinearLayout jKI;
    private final LinearLayout ksF;
    private InterfaceC0780a lFs;
    protected final LinearLayout lwY;
    protected final ColumnLayout lwZ;
    protected final ColumnLayout lxa;
    private int lxd;
    public LinearLayout lxe;
    public HeadImageView lxf;
    public TextView lxg;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0780a {
        /* renamed from: do  reason: not valid java name */
        void mo42do(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.lxe = (LinearLayout) view.findViewById(R.id.top_line);
        this.lxf = (HeadImageView) view.findViewById(R.id.portrait);
        this.ajb = (TextView) view.findViewById(R.id.username);
        this.evD = (TextView) view.findViewById(R.id.reply_time);
        this.ewA = (TextView) view.findViewById(R.id.forum_name);
        this.lxg = (TextView) view.findViewById(R.id.reply_count);
        this.ksF = (LinearLayout) view.findViewById(R.id.item_content);
        this.lwZ = (ColumnLayout) view.findViewById(R.id.item_header);
        this.lxa = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.jKI = (LinearLayout) view.findViewById(R.id.person_thread);
        this.lwY = (LinearLayout) view.findViewById(R.id.person_child);
        this.lxd = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.ksF != null) {
            this.ksF.setOnClickListener(this);
        }
        this.lxf.setOnClickListener(this);
        this.ajb.setOnClickListener(this);
        this.ewA.setOnClickListener(this);
        this.lxg.setOnClickListener(this);
        this.lwZ.setOnClickListener(this);
        this.lxa.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.lFs != null) {
            this.lFs.mo42do(view);
        }
    }

    public void a(InterfaceC0780a interfaceC0780a) {
        this.lFs = interfaceC0780a;
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
                str3 = at.getFormatTime(postInfoList.create_time * 1000);
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
                str3 = at.getFormatTime(postInfoList.create_time * 1000);
                str4 = postInfoList.forum_name;
                str5 = String.valueOf(postInfoList.reply_num);
            }
        } catch (Exception e) {
            z2 = false;
        }
        if (z2) {
            this.ajb.setText(str2);
            this.evD.setText(str3);
            this.ewA.setText(str4);
            this.ewA.setTag(str4);
            this.lxg.setText(str5);
            this.lxg.setTag(strArr);
            this.ewA.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                Pd(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                Pd(str);
            }
            if (this.ksF != null) {
                this.ksF.setTag(strArr);
            }
            this.lwZ.setTag(strArr);
            this.lxa.setTag(strArr);
        }
    }

    private void Pd(String str) {
        if (lxc != null && !lxc.equals(str)) {
            lxb = null;
        }
        if (lxb != null) {
            this.lxf.setImageBitmap(lxb.getRawBitmap());
            lxc = str;
            return;
        }
        this.lxf.a(str, 12, this.lxd, this.lxd, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.ewA, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.evD, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.ajb, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.jKI, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.lwY, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.lxg.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.lxg, R.color.cp_link_tip_c, 1);
    }
}
