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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private TextView hof;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private TextView mlE;
    private View.OnClickListener nPA;
    private View.OnClickListener nPB;
    private View.OnClickListener nPC;
    private View.OnClickListener nPD;
    private View.OnClickListener nPE;
    private View.OnClickListener nPF;
    private GuideScrollView.a nPG;
    private HeadPendantView nPa;
    private ImageView nPb;
    private TextView nPc;
    private TextView nPd;
    private TextView nPe;
    private TextView nPf;
    private TextView nPg;
    private TextView nPh;
    private TextView nPi;
    private TextView nPj;
    private TextView nPk;
    private TextView nPl;
    private RelativeLayout nPm;
    private RelativeLayout nPn;
    private RelativeLayout nPo;
    private RelativeLayout nPp;
    private TBSpecificationBtn nPq;
    private TBSpecificationBtn nPr;
    private GuideScrollView nPs;
    private View nPt;
    private HeadBorder nPu;
    private ForegroundColorSpan nPv;
    private ForegroundColorSpan nPw;
    private boolean nPx;
    private final String nPy;
    private final String nPz;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nPy = "认证：";
        this.nPz = "c13887";
        this.nPA = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bDO() != null && com.baidu.tbadk.getUserInfo.b.bDO().bDQ() != null) {
                    arVar.dY("uid", com.baidu.tbadk.getUserInfo.b.bDO().bDQ().getUserId());
                }
                arVar.dY("fid", GuidePopupWindow.this.mForumId);
                arVar.al("obj_locate", 1);
                TiebaStatic.log(arVar);
            }
        };
        this.nPB = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bDO() != null && com.baidu.tbadk.getUserInfo.b.bDO().bDQ() != null) {
                    arVar.dY("uid", com.baidu.tbadk.getUserInfo.b.bDO().bDQ().getUserId());
                }
                arVar.dY("fid", GuidePopupWindow.this.mForumId);
                arVar.al("obj_locate", 4);
                TiebaStatic.log(arVar);
            }
        };
        this.nPC = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bDO() != null && com.baidu.tbadk.getUserInfo.b.bDO().bDQ() != null) {
                    arVar.dY("uid", com.baidu.tbadk.getUserInfo.b.bDO().bDQ().getUserId());
                }
                arVar.dY("fid", GuidePopupWindow.this.mForumId);
                arVar.al("obj_locate", 3);
                TiebaStatic.log(arVar);
            }
        };
        this.nPD = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bDO() != null && com.baidu.tbadk.getUserInfo.b.bDO().bDQ() != null) {
                    arVar.dY("uid", com.baidu.tbadk.getUserInfo.b.bDO().bDQ().getUserId());
                }
                arVar.dY("fid", GuidePopupWindow.this.mForumId);
                arVar.al("obj_locate", 2);
                TiebaStatic.log(arVar);
            }
        };
        this.nPE = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bDO() != null && com.baidu.tbadk.getUserInfo.b.bDO().bDQ() != null) {
                    arVar.dY("uid", com.baidu.tbadk.getUserInfo.b.bDO().bDQ().getUserId());
                }
                arVar.dY("fid", GuidePopupWindow.this.mForumId);
                arVar.al("obj_locate", 6);
                TiebaStatic.log(arVar);
            }
        };
        this.nPF = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bDO() != null && com.baidu.tbadk.getUserInfo.b.bDO().bDQ() != null) {
                    arVar.dY("uid", com.baidu.tbadk.getUserInfo.b.bDO().bDQ().getUserId());
                }
                arVar.dY("fid", GuidePopupWindow.this.mForumId);
                arVar.al("obj_locate", 5);
                TiebaStatic.log(arVar);
            }
        };
        this.nPG = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nPt.setAlpha(GuidePopupWindow.this.nPs.getScrollY() / 150.0f);
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
        com.baidu.tieba.w.c.a(1, getWindow().getAttributes(), getWindow());
    }

    public void Vu(String str) {
        this.nPc.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void gk(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nPx = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            gl(list);
        }
    }

    public void H(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = au.dW(j).length();
        spannableStringBuilder.append((CharSequence) au.dW(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = au.dW(j2).length();
        spannableStringBuilder.append((CharSequence) au.dW(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.nPv, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nPw, length + 14 + 8, length + 22 + length2, 18);
        this.nPd.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void AX(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nPv = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        this.nPw = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0609);
        ap.setViewTextColor(this.hof, R.color.CAM_X0101);
        ap.setViewTextColor(this.nPd, R.color.CAM_X0101);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0616);
        ap.setViewTextColor(this.mlE, R.color.CAM_X0108);
        ap.setViewTextColor(this.nPe, R.color.CAM_X0101);
        ap.setViewTextColor(this.nPf, R.color.CAM_X0108);
        ap.setViewTextColor(this.nPg, R.color.CAM_X0101);
        ap.setViewTextColor(this.nPh, R.color.CAM_X0108);
        ap.setViewTextColor(this.nPi, R.color.CAM_X0101);
        ap.setViewTextColor(this.nPj, R.color.CAM_X0108);
        ap.setViewTextColor(this.nPk, R.color.CAM_X0101);
        ap.setViewTextColor(this.nPl, R.color.CAM_X0108);
        ap.setViewTextColor(this.nPc, R.color.CAM_X0108);
        ap.setViewTextColor(this.nPr, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.a(this.nPq, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
        ap.a(this.nPr, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
    }

    public void dXW() {
        if (com.baidu.tbadk.getUserInfo.b.bDO() != null && com.baidu.tbadk.getUserInfo.b.bDO().bDQ() != null) {
            this.hof.setText(com.baidu.tbadk.getUserInfo.b.bDO().bDQ().getName_show());
        }
    }

    public void dXX() {
        if (com.baidu.tbadk.getUserInfo.b.bDO() != null && com.baidu.tbadk.getUserInfo.b.bDO().bDQ() != null) {
            this.nPa.a(com.baidu.tbadk.getUserInfo.b.bDO().bDQ());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.nPa.a(userData);
        }
    }

    public void Vv(String str) {
        this.nPb.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nPs = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nPs.setScrollChangedListener(this.nPG);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nPa = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nPa.setHasPendantStyle();
        this.nPa.setDefalutResid(R.drawable.default_head);
        this.nPa.getHeadView().setIsRound(true);
        this.nPa.getHeadView().setDrawBorder(true);
        this.nPa.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nPa.setShowSimpleIcon(true);
        this.nPb = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.hof = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nPc = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nPd = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.mlE = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nPm = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nPe = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nPf = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nPn = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nPg = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nPh = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nPo = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nPi = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nPj = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nPp = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nPk = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nPl = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nPq = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nPq.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.rh(R.color.CAM_X0302);
        this.nPq.setConfig(cVar);
        this.nPq.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nPr = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.rh(R.color.CAM_X0618);
        this.nPr.setConfig(cVar2);
        this.nPr.setTextSize(R.dimen.tbds42);
        this.nPr.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nPt = this.mRootView.findViewById(R.id.shadow_top);
        this.nPt.setAlpha(0.0f);
        this.nPu = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nPu.setBorderColor(ap.getColor(R.color.CAM_X0614));
        this.nPu.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nPu.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dXY();
    }

    private void dXY() {
        this.nPm.setOnClickListener(this.nPA);
        this.nPn.setOnClickListener(this.nPB);
        this.nPo.setOnClickListener(this.nPC);
        this.nPp.setOnClickListener(this.nPD);
        this.nPq.setOnClickListener(this.nPE);
        this.nPr.setOnClickListener(this.nPF);
    }

    private void gl(final List<String> list) {
        this.nPc.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nPc.setText(GuidePopupWindow.this.gm(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gm(List<String> list) {
        String a2 = a(list, 0, true);
        if (Vw(a2) >= this.nPc.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (Vw(a3) < this.nPc.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int Vw(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nPc.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nPc.getPaint().measureText(str) + 0.5f));
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
        if (this.nPx) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nPJ;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nPJ, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nPJ = i;
        }
    }
}
