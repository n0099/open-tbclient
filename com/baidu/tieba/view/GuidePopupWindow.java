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
    private TextView heQ;
    private TextView lXe;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private TextView nAa;
    private TextView nAb;
    private TextView nAc;
    private RelativeLayout nAd;
    private RelativeLayout nAe;
    private RelativeLayout nAf;
    private RelativeLayout nAg;
    private TBSpecificationBtn nAh;
    private TBSpecificationBtn nAi;
    private GuideScrollView nAj;
    private View nAk;
    private HeadBorder nAl;
    private ForegroundColorSpan nAm;
    private ForegroundColorSpan nAn;
    private boolean nAo;
    private final String nAp;
    private final String nAq;
    private View.OnClickListener nAr;
    private View.OnClickListener nAs;
    private View.OnClickListener nAt;
    private View.OnClickListener nAu;
    private View.OnClickListener nAv;
    private View.OnClickListener nAw;
    private GuideScrollView.a nAx;
    private HeadPendantView nzR;
    private ImageView nzS;
    private TextView nzT;
    private TextView nzU;
    private TextView nzV;
    private TextView nzW;
    private TextView nzX;
    private TextView nzY;
    private TextView nzZ;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nAp = "认证：";
        this.nAq = "c13887";
        this.nAr = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAW() != null && com.baidu.tbadk.getUserInfo.b.bAW().bAY() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAW().bAY().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.al("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.nAs = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAW() != null && com.baidu.tbadk.getUserInfo.b.bAW().bAY() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAW().bAY().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.al("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.nAt = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAW() != null && com.baidu.tbadk.getUserInfo.b.bAW().bAY() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAW().bAY().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.al("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.nAu = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAW() != null && com.baidu.tbadk.getUserInfo.b.bAW().bAY() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAW().bAY().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.al("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.nAv = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAW() != null && com.baidu.tbadk.getUserInfo.b.bAW().bAY() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAW().bAY().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.al("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.nAw = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAW() != null && com.baidu.tbadk.getUserInfo.b.bAW().bAY() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAW().bAY().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.al("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.nAx = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nAk.setAlpha(GuidePopupWindow.this.nAj.getScrollY() / 150.0f);
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

    public void Uu(String str) {
        this.nzT.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void fW(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nAo = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            fX(list);
        }
    }

    public void I(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = at.dx(j).length();
        spannableStringBuilder.append((CharSequence) at.dx(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = at.dx(j2).length();
        spannableStringBuilder.append((CharSequence) at.dx(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.nAm, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nAn, length + 14 + 8, length + 22 + length2, 18);
        this.nzU.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void AV(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nAm = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        this.nAn = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundResource(this.mRootView, R.color.cp_mask_b_alpha83);
        ap.setViewTextColor(this.heQ, R.color.cp_cont_a);
        ap.setViewTextColor(this.nzU, R.color.cp_cont_a);
        ap.setBackgroundResource(this.mLine, R.color.cp_border_c_alpha33);
        ap.setViewTextColor(this.lXe, R.color.cp_cont_c);
        ap.setViewTextColor(this.nzV, R.color.cp_cont_a);
        ap.setViewTextColor(this.nzW, R.color.cp_cont_c);
        ap.setViewTextColor(this.nzX, R.color.cp_cont_a);
        ap.setViewTextColor(this.nzY, R.color.cp_cont_c);
        ap.setViewTextColor(this.nzZ, R.color.cp_cont_a);
        ap.setViewTextColor(this.nAa, R.color.cp_cont_c);
        ap.setViewTextColor(this.nAb, R.color.cp_cont_a);
        ap.setViewTextColor(this.nAc, R.color.cp_cont_c);
        ap.setViewTextColor(this.nzT, R.color.cp_cont_c);
        ap.setViewTextColor(this.nAi, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.a(this.nAh, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_link_tip_a, R.color.cp_link_tip_a, 1);
        ap.a(this.nAi, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_border_c_alpha50, R.color.cp_border_c_alpha50, 1);
    }

    public void dSD() {
        if (com.baidu.tbadk.getUserInfo.b.bAW() != null && com.baidu.tbadk.getUserInfo.b.bAW().bAY() != null) {
            this.heQ.setText(com.baidu.tbadk.getUserInfo.b.bAW().bAY().getName_show());
        }
    }

    public void dSE() {
        if (com.baidu.tbadk.getUserInfo.b.bAW() != null && com.baidu.tbadk.getUserInfo.b.bAW().bAY() != null) {
            this.nzR.a(com.baidu.tbadk.getUserInfo.b.bAW().bAY());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.nzR.a(userData);
        }
    }

    public void Uv(String str) {
        this.nzS.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nAj = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nAj.setScrollChangedListener(this.nAx);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nzR = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nzR.setHasPendantStyle();
        this.nzR.setDefalutResid(R.drawable.default_head);
        this.nzR.getHeadView().setIsRound(true);
        this.nzR.getHeadView().setDrawBorder(true);
        this.nzR.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nzR.setShowSimpleIcon(true);
        this.nzS = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.heQ = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nzT = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nzU = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.lXe = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nAd = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nzV = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nzW = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nAe = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nzX = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nzY = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nAf = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nzZ = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nAa = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nAg = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nAb = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nAc = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nAh = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nAh.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qi(R.color.cp_link_tip_a);
        this.nAh.setConfig(cVar);
        this.nAh.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nAi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.qi(R.color.cp_border_c_alpha50);
        this.nAi.setConfig(cVar2);
        this.nAi.setTextSize(R.dimen.tbds42);
        this.nAi.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nAk = this.mRootView.findViewById(R.id.shadow_top);
        this.nAk.setAlpha(0.0f);
        this.nAl = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nAl.setBorderColor(ap.getColor(R.color.cp_mask_c_alpha16));
        this.nAl.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nAl.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dSF();
    }

    private void dSF() {
        this.nAd.setOnClickListener(this.nAr);
        this.nAe.setOnClickListener(this.nAs);
        this.nAf.setOnClickListener(this.nAt);
        this.nAg.setOnClickListener(this.nAu);
        this.nAh.setOnClickListener(this.nAv);
        this.nAi.setOnClickListener(this.nAw);
    }

    private void fX(final List<String> list) {
        this.nzT.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nzT.setText(GuidePopupWindow.this.fY(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fY(List<String> list) {
        String a2 = a(list, 0, true);
        if (Uw(a2) >= this.nzT.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (Uw(a3) < this.nzT.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int Uw(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nzT.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nzT.getPaint().measureText(str) + 0.5f));
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
        if (this.nAo) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nAA;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nAA, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nAA = i;
        }
    }
}
