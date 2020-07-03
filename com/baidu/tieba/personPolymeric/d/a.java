package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes11.dex */
public class a extends ad.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a kOR;
    private static String kOS;
    public TextView ahA;
    public TextView edq;
    public TextView een;
    private final LinearLayout jMd;
    public ReplyLinearLayout kOM;
    public TextView kON;
    protected final LinearLayout kOO;
    protected final ColumnLayout kOP;
    protected final ColumnLayout kOQ;
    private int kOT;
    public LinearLayout kOU;
    public HeadImageView kOV;
    public TextView kOW;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.kOM = (ReplyLinearLayout) view.findViewById(R.id.content_container);
        this.kOM.setIsHost(this.mIsHost);
        this.kON = (TextView) view.findViewById(R.id.original_post_title);
        this.kOU = (LinearLayout) view.findViewById(R.id.top_line);
        this.kOV = (HeadImageView) view.findViewById(R.id.portrait);
        this.ahA = (TextView) view.findViewById(R.id.username);
        this.edq = (TextView) view.findViewById(R.id.reply_time);
        this.een = (TextView) view.findViewById(R.id.forum_name);
        this.kOW = (TextView) view.findViewById(R.id.reply_count);
        this.jMd = (LinearLayout) view.findViewById(R.id.item_content);
        this.kOP = (ColumnLayout) view.findViewById(R.id.item_header);
        this.kOQ = (ColumnLayout) view.findViewById(R.id.item_footer);
        this.kOO = (LinearLayout) view.findViewById(R.id.person_child);
        this.kOT = l.dip2px(view.getContext(), 42.0f);
        if (this.jMd != null) {
            this.jMd.setOnClickListener(this);
        }
        this.kOV.setOnClickListener(this);
        this.ahA.setOnClickListener(this);
        this.een.setOnClickListener(this);
        this.kOW.setOnClickListener(this);
        this.kOP.setOnClickListener(this);
        this.kOQ.setOnClickListener(this);
        this.kON.setOnClickListener(this);
    }

    public void changeSkin(int i) {
        an.setBackgroundResource(this.kON, R.color.cp_bg_line_e);
        an.setBackgroundColor(getView(), R.color.cp_bg_line_c);
        an.setBackgroundResource(this.kOO, R.drawable.daily_recommend_item_selector);
        an.setViewTextColor(this.ahA, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.edq, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.een, R.color.cp_cont_d, 1);
        an.setViewTextColor(this.kOW, R.color.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ao("c12043").ag("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.een) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.kON && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
                            formatTime = ar.getFormatTime(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            formatTime = ar.getFormatTime(postInfoList.create_time * 1000);
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
            this.ahA.setText(str4);
            this.edq.setText(str3);
            this.een.setText(str2);
            this.een.setTag(str2);
            this.kOW.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.comment_num_tip), str5));
            this.een.setOnClickListener(this);
            KU(str);
            if (this.jMd != null) {
                this.jMd.setTag(strArr);
            }
            this.kOP.setTag(strArr);
            this.kOQ.setTag(strArr);
        }
    }

    private void KU(String str) {
        if (kOS != null && !kOS.equals(str)) {
            kOR = null;
        }
        if (kOR != null) {
            this.kOV.setImageBitmap(kOR.getRawBitmap());
            kOS = str;
            return;
        }
        this.kOV.a(str, 12, this.kOT, this.kOT, false);
    }
}
