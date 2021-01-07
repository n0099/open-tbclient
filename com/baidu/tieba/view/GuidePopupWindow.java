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
    private TextView mqO;
    private TextView nSA;
    private TextView nSB;
    private TextView nSC;
    private TextView nSD;
    private TextView nSE;
    private TextView nSF;
    private TextView nSG;
    private TextView nSH;
    private TextView nSI;
    private RelativeLayout nSJ;
    private RelativeLayout nSK;
    private RelativeLayout nSL;
    private RelativeLayout nSM;
    private TBSpecificationBtn nSN;
    private TBSpecificationBtn nSO;
    private GuideScrollView nSP;
    private View nSQ;
    private HeadBorder nSR;
    private ForegroundColorSpan nSS;
    private ForegroundColorSpan nST;
    private boolean nSU;
    private final String nSV;
    private final String nSW;
    private View.OnClickListener nSX;
    private View.OnClickListener nSY;
    private View.OnClickListener nSZ;
    private HeadPendantView nSx;
    private ImageView nSy;
    private TextView nSz;
    private View.OnClickListener nTa;
    private View.OnClickListener nTb;
    private View.OnClickListener nTc;
    private GuideScrollView.a nTd;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nSV = "认证：";
        this.nSW = "c13887";
        this.nSX = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGj() != null && com.baidu.tbadk.getUserInfo.b.bGj().bGl() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGj().bGl().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.nSY = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGj() != null && com.baidu.tbadk.getUserInfo.b.bGj().bGl() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGj().bGl().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.nSZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGj() != null && com.baidu.tbadk.getUserInfo.b.bGj().bGl() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGj().bGl().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTa = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGj() != null && com.baidu.tbadk.getUserInfo.b.bGj().bGl() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGj().bGl().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTb = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGj() != null && com.baidu.tbadk.getUserInfo.b.bGj().bGl() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGj().bGl().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTc = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bGj() != null && com.baidu.tbadk.getUserInfo.b.bGj().bGl() != null) {
                    aqVar.dX("uid", com.baidu.tbadk.getUserInfo.b.bGj().bGl().getUserId());
                }
                aqVar.dX("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.nTd = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nSQ.setAlpha(GuidePopupWindow.this.nSP.getScrollY() / 150.0f);
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

    public void UY(String str) {
        this.nSz.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void ge(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nSU = true;
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
        spannableStringBuilder.setSpan(this.nSS, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nST, length + 14 + 8, length + 22 + length2, 18);
        this.nSA.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void AV(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nSS = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302));
        this.nST = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302));
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0609);
        ao.setViewTextColor(this.hAc, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSA, R.color.CAM_X0101);
        ao.setBackgroundResource(this.mLine, R.color.CAM_X0616);
        ao.setViewTextColor(this.mqO, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSB, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSC, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSD, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSE, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSF, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSG, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSH, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSI, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSz, R.color.CAM_X0108);
        ao.setViewTextColor(this.nSO, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ao.b(this.nSN, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
        ao.b(this.nSO, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
    }

    public void dXB() {
        if (com.baidu.tbadk.getUserInfo.b.bGj() != null && com.baidu.tbadk.getUserInfo.b.bGj().bGl() != null) {
            this.hAc.setText(com.baidu.tbadk.getUserInfo.b.bGj().bGl().getName_show());
        }
    }

    public void dXC() {
        if (com.baidu.tbadk.getUserInfo.b.bGj() != null && com.baidu.tbadk.getUserInfo.b.bGj().bGl() != null) {
            this.nSx.a(com.baidu.tbadk.getUserInfo.b.bGj().bGl());
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            this.nSx.a(userData);
        }
    }

    public void UZ(String str) {
        this.nSy.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nSP = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nSP.setScrollChangedListener(this.nTd);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nSx = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nSx.setHasPendantStyle();
        this.nSx.setDefalutResid(R.drawable.default_head);
        this.nSx.getHeadView().setIsRound(true);
        this.nSx.getHeadView().setDrawBorder(true);
        this.nSx.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nSx.setShowSimpleIcon(true);
        this.nSy = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.hAc = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nSz = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nSA = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.mqO = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nSJ = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nSB = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nSC = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nSK = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nSD = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nSE = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nSL = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nSF = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nSG = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nSM = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nSH = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nSI = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nSN = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nSN.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rs(R.color.CAM_X0302);
        this.nSN.setConfig(cVar);
        this.nSN.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nSO = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rs(R.color.CAM_X0618);
        this.nSO.setConfig(cVar2);
        this.nSO.setTextSize(R.dimen.tbds42);
        this.nSO.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nSQ = this.mRootView.findViewById(R.id.shadow_top);
        this.nSQ.setAlpha(0.0f);
        this.nSR = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nSR.setBorderColor(ao.getColor(R.color.CAM_X0614));
        this.nSR.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nSR.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dXD();
    }

    private void dXD() {
        this.nSJ.setOnClickListener(this.nSX);
        this.nSK.setOnClickListener(this.nSY);
        this.nSL.setOnClickListener(this.nSZ);
        this.nSM.setOnClickListener(this.nTa);
        this.nSN.setOnClickListener(this.nTb);
        this.nSO.setOnClickListener(this.nTc);
    }

    private void gf(final List<String> list) {
        this.nSz.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nSz.setText(GuidePopupWindow.this.gg(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gg(List<String> list) {
        String a2 = a(list, 0, true);
        if (Va(a2) >= this.nSz.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (Va(a3) < this.nSz.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int Va(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nSz.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nSz.getPaint().measureText(str) + 0.5f));
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
        if (this.nSU) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nTg;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nTg, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nTg = i;
        }
    }
}
