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
/* loaded from: classes18.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a loh;
    private static String loi;
    public TextView aiH;
    public TextView etz;
    public TextView euw;
    private final LinearLayout jCg;
    private final LinearLayout kkg;
    protected final LinearLayout lod;
    protected final ColumnLayout loe;
    protected final ColumnLayout lof;
    private int loj;
    public LinearLayout lok;
    public HeadImageView lol;
    public TextView lom;
    private InterfaceC0783a lwB;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC0783a {
        void dg(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.lok = (LinearLayout) view.findViewById(R.id.top_line);
        this.lol = (HeadImageView) view.findViewById(R.id.portrait);
        this.aiH = (TextView) view.findViewById(R.id.username);
        this.etz = (TextView) view.findViewById(R.id.reply_time);
        this.euw = (TextView) view.findViewById(R.id.forum_name);
        this.lom = (TextView) view.findViewById(R.id.reply_count);
        this.kkg = (LinearLayout) view.findViewById(R.id.item_content);
        this.loe = (ColumnLayout) view.findViewById(R.id.item_header);
        this.lof = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.jCg = (LinearLayout) view.findViewById(R.id.person_thread);
        this.lod = (LinearLayout) view.findViewById(R.id.person_child);
        this.loj = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.kkg != null) {
            this.kkg.setOnClickListener(this);
        }
        this.lol.setOnClickListener(this);
        this.aiH.setOnClickListener(this);
        this.euw.setOnClickListener(this);
        this.lom.setOnClickListener(this);
        this.loe.setOnClickListener(this);
        this.lof.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.lwB != null) {
            this.lwB.dg(view);
        }
    }

    public void a(InterfaceC0783a interfaceC0783a) {
        this.lwB = interfaceC0783a;
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
            this.aiH.setText(str2);
            this.etz.setText(str3);
            this.euw.setText(str4);
            this.euw.setTag(str4);
            this.lom.setText(str5);
            this.lom.setTag(strArr);
            this.euw.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                OC(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                OC(str);
            }
            if (this.kkg != null) {
                this.kkg.setTag(strArr);
            }
            this.loe.setTag(strArr);
            this.lof.setTag(strArr);
        }
    }

    private void OC(String str) {
        if (loi != null && !loi.equals(str)) {
            loh = null;
        }
        if (loh != null) {
            this.lol.setImageBitmap(loh.getRawBitmap());
            loi = str;
            return;
        }
        this.lol.a(str, 12, this.loj, this.loj, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.euw, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.etz, R.color.cp_cont_d, 1);
        ap.setViewTextColor(this.aiH, R.color.cp_cont_f, 1);
        ap.setBackgroundResource(this.jCg, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.lod, R.color.cp_bg_line_d);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.lom.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.lom, R.color.cp_link_tip_c, 1);
    }
}
