package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.util.OpenFlutter;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.GuideScrollView;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class GuidePopupWindow extends Dialog {
    private TextView gyF;
    private TextView lpz;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private HeadPendantView mRR;
    private ImageView mRS;
    private TextView mRT;
    private TextView mRU;
    private TextView mRV;
    private TextView mRW;
    private TextView mRX;
    private TextView mRY;
    private TextView mRZ;
    private View mRootView;
    private TextView mSa;
    private TextView mSb;
    private TextView mSc;
    private RelativeLayout mSd;
    private RelativeLayout mSe;
    private RelativeLayout mSf;
    private RelativeLayout mSg;
    private TBSpecificationBtn mSh;
    private TBSpecificationBtn mSi;
    private GuideScrollView mSj;
    private View mSk;
    private HeadBorder mSl;
    private ForegroundColorSpan mSm;
    private ForegroundColorSpan mSn;
    private boolean mSo;
    private final String mSq;
    private final String mSr;
    private View.OnClickListener mSs;
    private View.OnClickListener mSt;
    private View.OnClickListener mSu;
    private View.OnClickListener mSv;
    private View.OnClickListener mSw;
    private View.OnClickListener mSx;
    private GuideScrollView.a mSy;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.mSq = "认证：";
        this.mSr = "c13887";
        this.mSs = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.btU() != null && com.baidu.tbadk.getUserInfo.b.btU().btW() != null) {
                    aqVar.dF("uid", com.baidu.tbadk.getUserInfo.b.btU().btW().getUserId());
                }
                aqVar.dF("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.mSt = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.btU() != null && com.baidu.tbadk.getUserInfo.b.btU().btW() != null) {
                    aqVar.dF("uid", com.baidu.tbadk.getUserInfo.b.btU().btW().getUserId());
                }
                aqVar.dF("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.mSu = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.btU() != null && com.baidu.tbadk.getUserInfo.b.btU().btW() != null) {
                    aqVar.dF("uid", com.baidu.tbadk.getUserInfo.b.btU().btW().getUserId());
                }
                aqVar.dF("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.mSv = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.btU() != null && com.baidu.tbadk.getUserInfo.b.btU().btW() != null) {
                    aqVar.dF("uid", com.baidu.tbadk.getUserInfo.b.btU().btW().getUserId());
                }
                aqVar.dF("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.mSw = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.btU() != null && com.baidu.tbadk.getUserInfo.b.btU().btW() != null) {
                    aqVar.dF("uid", com.baidu.tbadk.getUserInfo.b.btU().btW().getUserId());
                }
                aqVar.dF("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.mSx = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.btU() != null && com.baidu.tbadk.getUserInfo.b.btU().btW() != null) {
                    aqVar.dF("uid", com.baidu.tbadk.getUserInfo.b.btU().btW().getUserId());
                }
                aqVar.dF("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.mSy = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.mSk.setAlpha(GuidePopupWindow.this.mSj.getScrollY() / 150.0f);
            }
        };
        this.mContext = context;
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.guide_popup_window, (ViewGroup) null);
        this.mRootView.setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
        getWindow().setDimAmount(0.0f);
        initView();
        onChangeSkinType();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mRootView);
        getWindow().setLayout(-1, -1);
        com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
    }

    public void SQ(String str) {
        this.mRT.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void fD(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.mSo = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            fE(list);
        }
    }

    public void G(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = at.cR(j).length();
        spannableStringBuilder.append((CharSequence) at.cR(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = at.cR(j2).length();
        spannableStringBuilder.append((CharSequence) at.cR(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.mSm, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.mSn, length + 14 + 8, length + 22 + length2, 18);
        this.mRU.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void zC(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.mSm = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        this.mSn = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundResource(this.mRootView, R.color.cp_mask_b_alpha83);
        ap.setViewTextColor(this.gyF, R.color.cp_cont_a);
        ap.setViewTextColor(this.mRU, R.color.cp_cont_a);
        ap.setBackgroundResource(this.mLine, R.color.cp_border_c_alpha33);
        ap.setViewTextColor(this.lpz, R.color.cp_cont_c);
        ap.setViewTextColor(this.mRV, R.color.cp_cont_a);
        ap.setViewTextColor(this.mRW, R.color.cp_cont_c);
        ap.setViewTextColor(this.mRX, R.color.cp_cont_a);
        ap.setViewTextColor(this.mRY, R.color.cp_cont_c);
        ap.setViewTextColor(this.mRZ, R.color.cp_cont_a);
        ap.setViewTextColor(this.mSa, R.color.cp_cont_c);
        ap.setViewTextColor(this.mSb, R.color.cp_cont_a);
        ap.setViewTextColor(this.mSc, R.color.cp_cont_c);
        ap.setViewTextColor(this.mRT, R.color.cp_cont_c);
        ap.setViewTextColor(this.mSi, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.a(this.mSh, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_link_tip_a, R.color.cp_link_tip_a, 1);
        ap.a(this.mSi, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_border_c_alpha50, R.color.cp_border_c_alpha50, 1);
    }

    public void dJh() {
        if (com.baidu.tbadk.getUserInfo.b.btU() != null && com.baidu.tbadk.getUserInfo.b.btU().btW() != null) {
            this.gyF.setText(com.baidu.tbadk.getUserInfo.b.btU().btW().getName_show());
        }
    }

    public void dJi() {
        if (com.baidu.tbadk.getUserInfo.b.btU() != null && com.baidu.tbadk.getUserInfo.b.btU().btW() != null) {
            this.mRR.a(com.baidu.tbadk.getUserInfo.b.btU().btW());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.mRR.a(userData);
        }
    }

    public void SR(String str) {
        this.mRS.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.mSj = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.mSj.setScrollChangedListener(this.mSy);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.mRR = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.mRR.setHasPendantStyle();
        this.mRR.setDefalutResid(R.drawable.default_head);
        this.mRR.getHeadView().setIsRound(true);
        this.mRR.getHeadView().setDrawBorder(true);
        this.mRR.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mRR.setShowSimpleIcon(true);
        this.mRS = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.gyF = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.mRT = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.mRU = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.lpz = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.mSd = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.mRV = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.mRW = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.mSe = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.mRX = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.mRY = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.mSf = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.mRZ = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.mSa = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.mSg = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.mSb = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.mSc = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.mSh = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.mSh.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pp(R.color.cp_link_tip_a);
        this.mSh.setConfig(cVar);
        this.mSh.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.mSi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pp(R.color.cp_border_c_alpha50);
        this.mSi.setConfig(cVar2);
        this.mSi.setTextSize(R.dimen.tbds42);
        this.mSi.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.mSk = this.mRootView.findViewById(R.id.shadow_top);
        this.mSk.setAlpha(0.0f);
        this.mSl = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.mSl.setBorderColor(ap.getColor(R.color.cp_mask_c_alpha16));
        this.mSl.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.mSl.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dJj();
    }

    private void dJj() {
        this.mSd.setOnClickListener(this.mSs);
        this.mSe.setOnClickListener(this.mSt);
        this.mSf.setOnClickListener(this.mSu);
        this.mSg.setOnClickListener(this.mSv);
        this.mSh.setOnClickListener(this.mSw);
        this.mSi.setOnClickListener(this.mSx);
    }

    private void fE(final List<String> list) {
        this.mRT.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.mRT.setText(GuidePopupWindow.this.fF(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fF(List<String> list) {
        String a = a(list, 0, true);
        if (SS(a) >= this.mRT.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a2 = a(list, i, false);
                if (SS(a2) < this.mRT.getWidth()) {
                    return a2;
                }
            }
            return null;
        }
        return a;
    }

    private int SS(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.mRT.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.mRT.getPaint().measureText(str) + 0.5f));
    }

    private String a(List<String> list, int i, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("认证：");
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str2 = list.get(i2);
            if (z) {
                str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
            } else if (str2.length() > i) {
                str = str2.substring(0, i - 1) + getContext().getResources().getString(R.string.guide_popup_window_join_field_bars_owner);
            } else {
                str = str2 + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner);
            }
            sb.append(str + "    ");
        }
        if (this.mSo) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int mSB;
        private Paint paint;

        public HeadBorder(Context context) {
            this(context, null);
        }

        public HeadBorder(Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public HeadBorder(Context context, @Nullable AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.STROKE);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mSB, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.mSB = i;
        }
    }
}
