package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes24.dex */
public class a extends af.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a mtn;
    private static String mto;
    public TextView aky;
    public TextView fcE;
    public TextView fdz;
    private final LinearLayout lod;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    public ReplyLinearLayout mti;
    public TextView mtj;
    protected final LinearLayout mtk;
    protected final ColumnLayout mtl;
    protected final ColumnLayout mtm;
    private int mtp;
    public LinearLayout mtq;
    public HeadImageView mtr;
    public TextView mts;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.mti = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.mti.setIsHost(this.mIsHost);
        this.mtj = (TextView) view.findViewById(R.id.original_post_title);
        this.mtq = (LinearLayout) view.findViewById(R.id.top_line);
        this.mtr = (HeadImageView) view.findViewById(R.id.portrait);
        this.aky = (TextView) view.findViewById(R.id.username);
        this.fcE = (TextView) view.findViewById(R.id.reply_time);
        this.fdz = (TextView) view.findViewById(R.id.forum_name);
        this.mts = (TextView) view.findViewById(R.id.reply_count);
        this.lod = (LinearLayout) view.findViewById(R.id.item_content);
        this.mtl = (ColumnLayout) view.findViewById(R.id.item_header);
        this.mtm = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.mtk = (LinearLayout) view.findViewById(R.id.person_child);
        this.mtp = l.dip2px(view.getContext(), 42.0f);
        if (this.lod != null) {
            this.lod.setOnClickListener(this);
        }
        this.mtr.setOnClickListener(this);
        this.aky.setOnClickListener(this);
        this.fdz.setOnClickListener(this);
        this.mts.setOnClickListener(this);
        this.mtl.setOnClickListener(this);
        this.mtm.setOnClickListener(this);
        this.mtj.setOnClickListener(this);
    }

    public void changeSkin(int i) {
        ap.setBackgroundResource(this.mtj, R.color.CAM_X0205);
        ap.setBackgroundColor(getView(), R.color.CAM_X0204);
        ap.setBackgroundResource(this.mtk, R.drawable.daily_recommend_item_selector);
        ap.setViewTextColor(this.aky, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.fcE, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.fdz, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mts, R.color.CAM_X0109, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ar("c12043").al("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.fdz) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.mtj && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String formatTime;
        String str7;
        String valueOf;
        String str8 = null;
        String str9 = 4;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            formatTime = au.getFormatTime(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            formatTime = au.getFormatTime(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = formatTime;
                        str2 = str7;
                        str9 = valueOf;
                        str8 = 1;
                        str5 = str9;
                    } catch (Exception e) {
                        str9 = str8;
                        str4 = str3;
                        str3 = str2;
                        str2 = str9;
                        str5 = str8;
                        str8 = null;
                        if (str8 != null) {
                        }
                    }
                } catch (Exception e2) {
                    str9 = str8;
                    str2 = str8;
                    str4 = str3;
                    str3 = str2;
                    str2 = str9;
                    str5 = str8;
                    str8 = null;
                    if (str8 != null) {
                    }
                }
            } catch (Exception e3) {
                str9 = 0;
                str2 = null;
                str3 = null;
                str4 = str3;
                str3 = str2;
                str2 = str9;
                str5 = str8;
                str8 = null;
                if (str8 != null) {
                }
            }
        } catch (Exception e4) {
            str4 = str3;
            str3 = str2;
            str2 = str9;
            str5 = str8;
            str8 = null;
            if (str8 != null) {
            }
        }
        if (str8 != null) {
            this.aky.setText(str4);
            this.fcE.setText(str3);
            this.fdz.setText(str2);
            this.fdz.setTag(str2);
            this.mts.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.fdz.setOnClickListener(this);
            Rl(str);
            if (this.lod != null) {
                this.lod.setTag(strArr);
            }
            this.mtl.setTag(strArr);
            this.mtm.setTag(strArr);
        }
    }

    private void Rl(String str) {
        if (mto != null && !mto.equals(str)) {
            mtn = null;
        }
        if (mtn != null) {
            this.mtr.setImageBitmap(mtn.getRawBitmap());
            mto = str;
            return;
        }
        this.mtr.a(str, 12, this.mtp, this.mtp, false);
    }
}
