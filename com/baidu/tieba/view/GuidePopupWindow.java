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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.GuideScrollView;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class GuidePopupWindow extends Dialog {
    private TextView gjn;
    private TextView kQH;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private HeadPendantView mpG;
    private ImageView mpH;
    private TextView mpI;
    private TextView mpJ;
    private TextView mpK;
    private TextView mpL;
    private TextView mpM;
    private TextView mpN;
    private TextView mpO;
    private TextView mpP;
    private TextView mpQ;
    private TextView mpR;
    private RelativeLayout mpS;
    private RelativeLayout mpT;
    private RelativeLayout mpU;
    private RelativeLayout mpV;
    private TBSpecificationBtn mpW;
    private TBSpecificationBtn mpX;
    private GuideScrollView mpY;
    private View mpZ;
    private HeadBorder mqa;
    private ForegroundColorSpan mqb;
    private ForegroundColorSpan mqc;
    private boolean mqd;
    private final String mqe;
    private final String mqf;
    private View.OnClickListener mqg;
    private View.OnClickListener mqh;
    private View.OnClickListener mqi;
    private View.OnClickListener mqj;
    private View.OnClickListener mqk;
    private View.OnClickListener mql;
    private GuideScrollView.a mqm;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.mqe = "认证：";
        this.mqf = "c13887";
        this.mqg = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                ap apVar = new ap("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                    apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
                }
                apVar.dn("fid", GuidePopupWindow.this.mForumId);
                apVar.ah("obj_locate", 1);
                TiebaStatic.log(apVar);
            }
        };
        this.mqh = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                ap apVar = new ap("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                    apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
                }
                apVar.dn("fid", GuidePopupWindow.this.mForumId);
                apVar.ah("obj_locate", 4);
                TiebaStatic.log(apVar);
            }
        };
        this.mqi = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                ap apVar = new ap("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                    apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
                }
                apVar.dn("fid", GuidePopupWindow.this.mForumId);
                apVar.ah("obj_locate", 3);
                TiebaStatic.log(apVar);
            }
        };
        this.mqj = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                ap apVar = new ap("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                    apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
                }
                apVar.dn("fid", GuidePopupWindow.this.mForumId);
                apVar.ah("obj_locate", 2);
                TiebaStatic.log(apVar);
            }
        };
        this.mqk = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumDetail", hashMap)));
                ap apVar = new ap("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                    apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
                }
                apVar.dn("fid", GuidePopupWindow.this.mForumId);
                apVar.ah("obj_locate", 6);
                TiebaStatic.log(apVar);
            }
        };
        this.mql = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                ap apVar = new ap("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
                    apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
                }
                apVar.dn("fid", GuidePopupWindow.this.mForumId);
                apVar.ah("obj_locate", 5);
                TiebaStatic.log(apVar);
            }
        };
        this.mqm = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.mpZ.setAlpha(GuidePopupWindow.this.mpY.getScrollY() / 150.0f);
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

    public void Ps(String str) {
        this.mpI.setText("认证：" + str + "吧吧主");
    }

    public void fm(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.mqd = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            fn(list);
        }
    }

    public void J(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = as.cF(j).length();
        spannableStringBuilder.append((CharSequence) as.cF(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = as.cF(j2).length();
        spannableStringBuilder.append((CharSequence) as.cF(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.mqb, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.mqc, length + 14 + 8, length + 22 + length2, 18);
        this.mpJ.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void wS(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.mqb = new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_a));
        this.mqc = new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_a));
        ao.setBackgroundResource(this.mRootView, R.color.cp_mask_b_alpha83);
        ao.setViewTextColor(this.gjn, R.color.cp_cont_a);
        ao.setViewTextColor(this.mpJ, R.color.cp_cont_a);
        ao.setBackgroundResource(this.mLine, R.color.cp_border_c_alpha33);
        ao.setViewTextColor(this.kQH, R.color.cp_cont_c);
        ao.setViewTextColor(this.mpK, R.color.cp_cont_a);
        ao.setViewTextColor(this.mpL, R.color.cp_cont_c);
        ao.setViewTextColor(this.mpM, R.color.cp_cont_a);
        ao.setViewTextColor(this.mpN, R.color.cp_cont_c);
        ao.setViewTextColor(this.mpO, R.color.cp_cont_a);
        ao.setViewTextColor(this.mpP, R.color.cp_cont_c);
        ao.setViewTextColor(this.mpQ, R.color.cp_cont_a);
        ao.setViewTextColor(this.mpR, R.color.cp_cont_c);
        ao.setViewTextColor(this.mpI, R.color.cp_cont_c);
        ao.setViewTextColor(this.mpX, R.color.cp_cont_a_alpha20);
        ao.a(this.mpW, 60, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_link_tip_a, R.color.cp_link_tip_a, 1);
        ao.a(this.mpX, 60, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_border_c_alpha50, R.color.cp_border_c_alpha50, 1);
    }

    public void dtJ() {
        if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
            this.gjn.setText(com.baidu.tbadk.getUserInfo.b.bkd().bkf().getName_show());
        }
    }

    public void dtK() {
        if (com.baidu.tbadk.getUserInfo.b.bkd() != null && com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
            this.mpG.a(com.baidu.tbadk.getUserInfo.b.bkd().bkf());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.mpG.a(userData);
        }
    }

    public void Pt(String str) {
        this.mpH.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.mpY = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.mpY.setScrollChangedListener(this.mqm);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.mpG = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.mpG.setHasPendantStyle();
        this.mpG.setDefalutResid(R.drawable.default_head);
        this.mpG.getHeadView().setIsRound(true);
        this.mpG.getHeadView().setDrawBorder(true);
        this.mpG.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mpG.setShowSimpleIcon(true);
        this.mpH = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.gjn = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.mpI = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.mpJ = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.kQH = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.mpS = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.mpK = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.mpL = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.mpT = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.mpM = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.mpN = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.mpU = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.mpO = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.mpP = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.mpV = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.mpQ = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.mpR = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.mpW = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.mpW.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
        dVar.mV(R.color.cp_link_tip_a);
        this.mpW.setConfig(dVar);
        this.mpW.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.mpX = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.d dVar2 = new com.baidu.tbadk.core.view.commonBtn.d();
        dVar2.mV(R.color.cp_border_c_alpha50);
        this.mpX.setConfig(dVar2);
        this.mpX.setTextSize(R.dimen.tbds42);
        this.mpX.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.mpZ = this.mRootView.findViewById(R.id.shadow_top);
        this.mpZ.setAlpha(0.0f);
        this.mqa = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.mqa.setBorderColor(ao.getColor(R.color.cp_mask_c_alpha16));
        this.mqa.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.mqa.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dtL();
    }

    private void dtL() {
        this.mpS.setOnClickListener(this.mqg);
        this.mpT.setOnClickListener(this.mqh);
        this.mpU.setOnClickListener(this.mqi);
        this.mpV.setOnClickListener(this.mqj);
        this.mpW.setOnClickListener(this.mqk);
        this.mpX.setOnClickListener(this.mql);
    }

    private void fn(final List<String> list) {
        this.mpI.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.mpI.setText(GuidePopupWindow.this.fo(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fo(List<String> list) {
        String a = a(list, 0, true);
        if (Pu(a) >= this.mpI.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a2 = a(list, i, false);
                if (Pu(a2) < this.mpI.getWidth()) {
                    return a2;
                }
            }
            return null;
        }
        return a;
    }

    private int Pu(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.mpI.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.mpI.getPaint().measureText(str) + 0.5f));
    }

    private String a(List<String> list, int i, boolean z) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("认证：");
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str2 = list.get(i2);
            if (z) {
                str = str2 + "吧吧主";
            } else if (str2.length() > i) {
                str = str2.substring(0, i - 1) + "...吧主";
            } else {
                str = str2 + "吧吧主";
            }
            sb.append(str + "    ");
        }
        if (this.mqd) {
            return sb.toString().substring(0, sb.toString().length() - 4) + "....";
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int mqp;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mqp, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.mqp = i;
        }
    }
}
