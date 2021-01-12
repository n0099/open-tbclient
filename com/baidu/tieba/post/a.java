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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a mtV;
    private static String mtW;
    public TextView akj;
    public TextView fhC;
    public TextView fiz;
    private final LinearLayout kGM;
    private final LinearLayout loO;
    private InterfaceC0846a mCk;
    private TbPageContext<?> mPageContext;
    protected final LinearLayout mtS;
    protected final ColumnLayout mtT;
    protected final ColumnLayout mtU;
    private int mtX;
    public LinearLayout mtY;
    public HeadImageView mtZ;
    public TextView mua;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0846a {
        void ea(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mtY = (LinearLayout) view.findViewById(R.id.top_line);
        this.mtZ = (HeadImageView) view.findViewById(R.id.portrait);
        this.akj = (TextView) view.findViewById(R.id.username);
        this.fhC = (TextView) view.findViewById(R.id.reply_time);
        this.fiz = (TextView) view.findViewById(R.id.forum_name);
        this.mua = (TextView) view.findViewById(R.id.reply_count);
        this.loO = (LinearLayout) view.findViewById(R.id.item_content);
        this.mtT = (ColumnLayout) view.findViewById(R.id.item_header);
        this.mtU = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.kGM = (LinearLayout) view.findViewById(R.id.person_thread);
        this.mtS = (LinearLayout) view.findViewById(R.id.person_child);
        this.mtX = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.loO != null) {
            this.loO.setOnClickListener(this);
        }
        this.mtZ.setOnClickListener(this);
        this.akj.setOnClickListener(this);
        this.fiz.setOnClickListener(this);
        this.mua.setOnClickListener(this);
        this.mtT.setOnClickListener(this);
        this.mtU.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.mCk != null) {
            this.mCk.ea(view);
        }
    }

    public void a(InterfaceC0846a interfaceC0846a) {
        this.mCk = interfaceC0846a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            str5 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            str4 = at.getFormatTime(postInfoList.create_time * 1000);
                            str3 = postInfoList.forum_name;
                            str2 = String.valueOf(postInfoList.reply_num);
                            try {
                                strArr[3] = String.valueOf(postInfoList.thread_type);
                            } catch (Exception e) {
                                str6 = null;
                                if (str6 == null) {
                                }
                            }
                        } else {
                            str5 = StringUtils.isNull(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = at.getFormatTime(postInfoList.create_time * 1000);
                            str3 = postInfoList.forum_name;
                            str2 = String.valueOf(postInfoList.reply_num);
                        }
                        str6 = 1;
                    } catch (Exception e2) {
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                    }
                } catch (Exception e3) {
                    str2 = str6;
                    str3 = str6;
                }
            } catch (Exception e4) {
                str2 = str6;
                str3 = str6;
                str4 = str6;
            }
        } catch (Exception e5) {
            str2 = str6;
        }
        if (str6 == null) {
            this.akj.setText(str5);
            this.fhC.setText(str4);
            this.fiz.setText(str3);
            this.fiz.setTag(str3);
            this.mua.setText(str2);
            this.mua.setTag(strArr);
            this.fiz.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                PI(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                PI(str);
            }
            if (this.loO != null) {
                this.loO.setTag(strArr);
            }
            this.mtT.setTag(strArr);
            this.mtU.setTag(strArr);
        }
    }

    private void PI(String str) {
        if (mtW != null && !mtW.equals(str)) {
            mtV = null;
        }
        if (mtV != null) {
            this.mtZ.setImageBitmap(mtV.getRawBitmap());
            mtW = str;
            return;
        }
        this.mtZ.a(str, 12, this.mtX, this.mtX, false);
    }

    public void changeSkin(int i) {
        ao.setViewTextColor(this.fiz, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.fhC, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.akj, R.color.CAM_X0106, 1);
        ao.setBackgroundResource(this.kGM, R.color.CAM_X0204);
        ao.setBackgroundResource(this.mtS, R.color.CAM_X0201);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        this.mua.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setViewTextColor(this.mua, R.color.CAM_X0304, 1);
    }
}
