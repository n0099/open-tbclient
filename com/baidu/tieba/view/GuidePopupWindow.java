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
/* loaded from: classes2.dex */
public class GuidePopupWindow extends Dialog {
    private TextView gvq;
    private TextView lgx;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private HeadPendantView mHO;
    private ImageView mHP;
    private TextView mHQ;
    private TextView mHR;
    private TextView mHS;
    private TextView mHT;
    private TextView mHU;
    private TextView mHV;
    private TextView mHW;
    private TextView mHX;
    private TextView mHY;
    private TextView mHZ;
    private RelativeLayout mIa;
    private RelativeLayout mIb;
    private RelativeLayout mIc;
    private RelativeLayout mIe;
    private TBSpecificationBtn mIf;
    private TBSpecificationBtn mIg;
    private GuideScrollView mIh;
    private View mIi;
    private HeadBorder mIj;
    private ForegroundColorSpan mIk;
    private ForegroundColorSpan mIl;
    private boolean mIm;
    private final String mIn;
    private final String mIo;
    private View.OnClickListener mIq;
    private View.OnClickListener mIr;
    private View.OnClickListener mIt;
    private View.OnClickListener mIu;
    private View.OnClickListener mIv;
    private View.OnClickListener mIw;
    private GuideScrollView.a mIx;
    private View mLine;
    private View mRootView;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.mIn = "认证：";
        this.mIo = "c13887";
        this.mIq = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsP() != null && com.baidu.tbadk.getUserInfo.b.bsP().bsR() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsP().bsR().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIr = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsP() != null && com.baidu.tbadk.getUserInfo.b.bsP().bsR() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsP().bsR().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIt = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsP() != null && com.baidu.tbadk.getUserInfo.b.bsP().bsR() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsP().bsR().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIu = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsP() != null && com.baidu.tbadk.getUserInfo.b.bsP().bsR() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsP().bsR().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIv = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsP() != null && com.baidu.tbadk.getUserInfo.b.bsP().bsR() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsP().bsR().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIw = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsP() != null && com.baidu.tbadk.getUserInfo.b.bsP().bsR() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsP().bsR().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIx = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.mIi.setAlpha(GuidePopupWindow.this.mIh.getScrollY() / 150.0f);
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

    public void Sq(String str) {
        this.mHQ.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void fu(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.mIm = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            fv(list);
        }
    }

    public void J(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = at.cQ(j).length();
        spannableStringBuilder.append((CharSequence) at.cQ(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = at.cQ(j2).length();
        spannableStringBuilder.append((CharSequence) at.cQ(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.mIk, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.mIl, length + 14 + 8, length + 22 + length2, 18);
        this.mHR.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void zg(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.mIk = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        this.mIl = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundResource(this.mRootView, R.color.cp_mask_b_alpha83);
        ap.setViewTextColor(this.gvq, R.color.cp_cont_a);
        ap.setViewTextColor(this.mHR, R.color.cp_cont_a);
        ap.setBackgroundResource(this.mLine, R.color.cp_border_c_alpha33);
        ap.setViewTextColor(this.lgx, R.color.cp_cont_c);
        ap.setViewTextColor(this.mHS, R.color.cp_cont_a);
        ap.setViewTextColor(this.mHT, R.color.cp_cont_c);
        ap.setViewTextColor(this.mHU, R.color.cp_cont_a);
        ap.setViewTextColor(this.mHV, R.color.cp_cont_c);
        ap.setViewTextColor(this.mHW, R.color.cp_cont_a);
        ap.setViewTextColor(this.mHX, R.color.cp_cont_c);
        ap.setViewTextColor(this.mHY, R.color.cp_cont_a);
        ap.setViewTextColor(this.mHZ, R.color.cp_cont_c);
        ap.setViewTextColor(this.mHQ, R.color.cp_cont_c);
        ap.setViewTextColor(this.mIg, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.a(this.mIf, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_link_tip_a, R.color.cp_link_tip_a, 1);
        ap.a(this.mIg, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_border_c_alpha50, R.color.cp_border_c_alpha50, 1);
    }

    public void dFe() {
        if (com.baidu.tbadk.getUserInfo.b.bsP() != null && com.baidu.tbadk.getUserInfo.b.bsP().bsR() != null) {
            this.gvq.setText(com.baidu.tbadk.getUserInfo.b.bsP().bsR().getName_show());
        }
    }

    public void dFf() {
        if (com.baidu.tbadk.getUserInfo.b.bsP() != null && com.baidu.tbadk.getUserInfo.b.bsP().bsR() != null) {
            this.mHO.a(com.baidu.tbadk.getUserInfo.b.bsP().bsR());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.mHO.a(userData);
        }
    }

    public void Sr(String str) {
        this.mHP.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.mIh = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.mIh.setScrollChangedListener(this.mIx);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.mHO = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.mHO.setHasPendantStyle();
        this.mHO.setDefalutResid(R.drawable.default_head);
        this.mHO.getHeadView().setIsRound(true);
        this.mHO.getHeadView().setDrawBorder(true);
        this.mHO.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mHO.setShowSimpleIcon(true);
        this.mHP = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.gvq = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.mHQ = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.mHR = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.lgx = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.mIa = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.mHS = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.mHT = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.mIb = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.mHU = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.mHV = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.mIc = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.mHW = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.mHX = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.mIe = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.mHY = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.mHZ = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.mIf = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.mIf.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pb(R.color.cp_link_tip_a);
        this.mIf.setConfig(cVar);
        this.mIf.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.mIg = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pb(R.color.cp_border_c_alpha50);
        this.mIg.setConfig(cVar2);
        this.mIg.setTextSize(R.dimen.tbds42);
        this.mIg.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.mIi = this.mRootView.findViewById(R.id.shadow_top);
        this.mIi.setAlpha(0.0f);
        this.mIj = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.mIj.setBorderColor(ap.getColor(R.color.cp_mask_c_alpha16));
        this.mIj.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.mIj.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dFg();
    }

    private void dFg() {
        this.mIa.setOnClickListener(this.mIq);
        this.mIb.setOnClickListener(this.mIr);
        this.mIc.setOnClickListener(this.mIt);
        this.mIe.setOnClickListener(this.mIu);
        this.mIf.setOnClickListener(this.mIv);
        this.mIg.setOnClickListener(this.mIw);
    }

    private void fv(final List<String> list) {
        this.mHQ.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.mHQ.setText(GuidePopupWindow.this.fw(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fw(List<String> list) {
        String a = a(list, 0, true);
        if (Ss(a) >= this.mHQ.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a2 = a(list, i, false);
                if (Ss(a2) < this.mHQ.getWidth()) {
                    return a2;
                }
            }
            return null;
        }
        return a;
    }

    private int Ss(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.mHQ.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.mHQ.getPaint().measureText(str) + 0.5f));
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
        if (this.mIm) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes2.dex */
    public static class HeadBorder extends View {
        private int mIA;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mIA, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.mIA = i;
        }
    }
}
