package com.baidu.tieba.post;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a mFq;
    private static String mFr;
    public TextView alr;
    public TextView flu;
    public ImageView flx;
    public TextView fmq;
    private final LinearLayout kRg;
    private final LinearLayout lzi;
    protected final LinearLayout mFn;
    protected final ColumnLayout mFo;
    protected final ColumnLayout mFp;
    private int mFs;
    public LinearLayout mFt;
    public HeadImageView mFu;
    public TextView mFv;
    private InterfaceC0856a mNK;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0856a {
        void dY(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mFt = (LinearLayout) view.findViewById(R.id.top_line);
        this.mFu = (HeadImageView) view.findViewById(R.id.portrait);
        this.alr = (TextView) view.findViewById(R.id.username);
        this.flu = (TextView) view.findViewById(R.id.reply_time);
        this.fmq = (TextView) view.findViewById(R.id.forum_name);
        this.mFv = (TextView) view.findViewById(R.id.reply_count);
        this.lzi = (LinearLayout) view.findViewById(R.id.item_content);
        this.mFo = (ColumnLayout) view.findViewById(R.id.item_header);
        this.mFp = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.kRg = (LinearLayout) view.findViewById(R.id.person_thread);
        this.mFn = (LinearLayout) view.findViewById(R.id.person_child);
        this.flx = (ImageView) view.findViewById(R.id.comment_icon);
        this.mFs = com.baidu.adp.lib.util.l.dip2px(view.getContext(), 42.0f);
        if (this.lzi != null) {
            this.lzi.setOnClickListener(this);
        }
        this.mFu.setOnClickListener(this);
        this.alr.setOnClickListener(this);
        this.fmq.setOnClickListener(this);
        this.mFv.setOnClickListener(this);
        this.mFo.setOnClickListener(this);
        this.mFp.setOnClickListener(this);
        this.mFv.setText(R.string.reply_me);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.mNK != null) {
            this.mNK.dY(view);
        }
    }

    public void a(InterfaceC0856a interfaceC0856a) {
        this.mNK = interfaceC0856a;
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
                            str4 = au.getFormatTime(postInfoList.create_time * 1000);
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
                            str4 = au.getFormatTime(postInfoList.create_time * 1000);
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
            this.alr.setText(str5);
            this.flu.setText(str4);
            this.fmq.setText(str3);
            this.fmq.setTag(str3);
            this.mFv.setText(str2);
            this.mFv.setTag(strArr);
            this.fmq.setOnClickListener(this);
            if (postInfoList.mBaijiahaoInfo != null && !StringUtils.isNull(postInfoList.mBaijiahaoInfo.avatar)) {
                QH(postInfoList.mBaijiahaoInfo.avatar);
            } else {
                QH(str);
            }
            if (this.lzi != null) {
                this.lzi.setTag(strArr);
            }
            this.mFo.setTag(strArr);
            this.mFp.setTag(strArr);
        }
    }

    private void QH(String str) {
        if (mFr != null && !mFr.equals(str)) {
            mFq = null;
        }
        if (mFq != null) {
            this.mFu.setImageBitmap(mFq.getRawBitmap());
            mFr = str;
            return;
        }
        this.mFu.a(str, 12, this.mFs, this.mFs, false);
    }

    public void changeSkin(int i) {
        ap.setViewTextColor(this.fmq, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.flu, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.alr, R.color.CAM_X0106, 1);
        ap.setBackgroundResource(this.kRg, R.color.CAM_X0204);
        ap.setBackgroundResource(this.mFn, R.color.CAM_X0201);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
        }
        ap.setViewTextColor(this.mFv, R.color.CAM_X0105);
        WebPManager.a(this.flx, R.drawable.icon_pure_card_comment22, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }
}
