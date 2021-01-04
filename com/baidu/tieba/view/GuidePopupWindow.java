package com.baidu.tieba.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
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
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
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
    private TextView hAc;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private TextView mqP;
    private TextView nSA;
    private TextView nSB;
    private TextView nSC;
    private TextView nSD;
    private TextView nSE;
    private TextView nSF;
    private TextView nSG;
    private TextView nSH;
    private TextView nSI;
    private TextView nSJ;
    private RelativeLayout nSK;
    private RelativeLayout nSL;
    private RelativeLayout nSM;
    private RelativeLayout nSN;
    private TBSpecificationBtn nSO;
    private TBSpecificationBtn nSP;
    private GuideScrollView nSQ;
    private View nSR;
    private HeadBorder nSS;
    private ForegroundColorSpan nST;
    private ForegroundColorSpan nSU;
    private boolean nSV;
    private final String nSW;
    private final String nSX;
    private View.OnClickListener nSY;
    private View.OnClickListener nSZ;
    private HeadPendantView nSy;
    private ImageView nSz;
    private View.OnClickListener nTa;
    private View.OnClickListener nTb;
    private View.OnClickListener nTc;
    private View.OnClickListener nTd;
    private GuideScrollView.a nTe;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nSW = "认证：";
        this.nSX = "c13887";
        this.nSY = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGi() != null && com.baidu.tbadk.getUserInfo.b.bGi().bGk() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGi().bGk().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.nSZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGi() != null && com.baidu.tbadk.getUserInfo.b.bGi().bGk() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGi().bGk().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTa = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGi() != null && com.baidu.tbadk.getUserInfo.b.bGi().bGk() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGi().bGk().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTb = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGi() != null && com.baidu.tbadk.getUserInfo.b.bGi().bGk() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGi().bGk().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTc = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGi() != null && com.baidu.tbadk.getUserInfo.b.bGi().bGk() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGi().bGk().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTd = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGi() != null && com.baidu.tbadk.getUserInfo.b.bGi().bGk() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGi().bGk().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTe = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nSR.setAlpha(GuidePopupWindow.this.nSQ.getScrollY() / 150.0f);
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

    public void UZ(String str) {
        this.nSA.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void ge(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nSV = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            gf(list);
        }
    }

    public void K(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = at.dW(j).length();
        spannableStringBuilder.append((CharSequence) at.dW(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = at.dW(j2).length();
        spannableStringBuilder.append((CharSequence) at.dW(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.nST, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nSU, length + 14 + 8, length + 22 + length2, 18);
        this.nSB.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void AW(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nST = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302));
        this.nSU = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302));
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0609);
        ao.setViewTextColor(this.hAc, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSB, R.color.CAM_X0101);
        ao.setBackgroundResource(this.mLine, R.color.CAM_X0616);
        ao.setViewTextColor(this.mqP, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSC, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSD, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSE, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSF, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSG, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSH, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSI, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSJ, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSA, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSP, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ao.b(this.nSO, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
        ao.b(this.nSP, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
    }

    public void dXA() {
        if (com.baidu.tbadk.getUserInfo.b.bGi() != null && com.baidu.tbadk.getUserInfo.b.bGi().bGk() != null) {
            this.hAc.setText(com.baidu.tbadk.getUserInfo.b.bGi().bGk().getName_show());
        }
    }

    public void dXB() {
        if (com.baidu.tbadk.getUserInfo.b.bGi() != null && com.baidu.tbadk.getUserInfo.b.bGi().bGk() != null) {
            this.nSy.a(com.baidu.tbadk.getUserInfo.b.bGi().bGk());
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            this.nSy.a(userData);
        }
    }

    public void Va(String str) {
        this.nSz.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nSQ = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nSQ.setScrollChangedListener(this.nTe);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nSy = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nSy.setHasPendantStyle();
        this.nSy.setDefalutResid(R.drawable.default_head);
        this.nSy.getHeadView().setIsRound(true);
        this.nSy.getHeadView().setDrawBorder(true);
        this.nSy.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nSy.setShowSimpleIcon(true);
        this.nSz = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.hAc = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nSA = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nSB = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.mqP = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nSK = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nSC = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nSD = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nSL = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nSE = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nSF = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nSM = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nSG = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nSH = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nSN = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nSI = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nSJ = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nSO = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nSO.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rs(R.color.CAM_X0302);
        this.nSO.setConfig(cVar);
        this.nSO.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nSP = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rs(R.color.CAM_X0618);
        this.nSP.setConfig(cVar2);
        this.nSP.setTextSize(R.dimen.tbds42);
        this.nSP.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nSR = this.mRootView.findViewById(R.id.shadow_top);
        this.nSR.setAlpha(0.0f);
        this.nSS = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nSS.setBorderColor(ao.getColor(R.color.CAM_X0614));
        this.nSS.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nSS.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dXC();
    }

    private void dXC() {
        this.nSK.setOnClickListener(this.nSY);
        this.nSL.setOnClickListener(this.nSZ);
        this.nSM.setOnClickListener(this.nTa);
        this.nSN.setOnClickListener(this.nTb);
        this.nSO.setOnClickListener(this.nTc);
        this.nSP.setOnClickListener(this.nTd);
    }

    private void gf(final List<String> list) {
        this.nSA.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nSA.setText(GuidePopupWindow.this.gg(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gg(List<String> list) {
        String a2 = a(list, 0, true);
        if (Vb(a2) >= this.nSA.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (Vb(a3) < this.nSA.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int Vb(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nSA.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nSA.getPaint().measureText(str) + 0.5f));
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
        if (this.nSV) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nTh;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nTh, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nTh = i;
        }
    }
}
