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
    private TextView gMY;
    private TextView lEM;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private TextView nhA;
    private TextView nhB;
    private TextView nhC;
    private TextView nhD;
    private TextView nhE;
    private TextView nhF;
    private TextView nhG;
    private RelativeLayout nhH;
    private RelativeLayout nhI;
    private RelativeLayout nhJ;
    private RelativeLayout nhK;
    private TBSpecificationBtn nhL;
    private TBSpecificationBtn nhM;
    private GuideScrollView nhN;
    private View nhO;
    private HeadBorder nhP;
    private ForegroundColorSpan nhQ;
    private ForegroundColorSpan nhR;
    private boolean nhS;
    private final String nhT;
    private final String nhU;
    private View.OnClickListener nhV;
    private View.OnClickListener nhW;
    private View.OnClickListener nhX;
    private View.OnClickListener nhY;
    private View.OnClickListener nhZ;
    private HeadPendantView nhv;
    private ImageView nhw;
    private TextView nhx;
    private TextView nhy;
    private TextView nhz;
    private View.OnClickListener nia;
    private GuideScrollView.a nib;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nhT = "认证：";
        this.nhU = "c13887";
        this.nhV = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bwE() != null && com.baidu.tbadk.getUserInfo.b.bwE().bwG() != null) {
                    aqVar.dK("uid", com.baidu.tbadk.getUserInfo.b.bwE().bwG().getUserId());
                }
                aqVar.dK("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.nhW = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bwE() != null && com.baidu.tbadk.getUserInfo.b.bwE().bwG() != null) {
                    aqVar.dK("uid", com.baidu.tbadk.getUserInfo.b.bwE().bwG().getUserId());
                }
                aqVar.dK("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.nhX = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bwE() != null && com.baidu.tbadk.getUserInfo.b.bwE().bwG() != null) {
                    aqVar.dK("uid", com.baidu.tbadk.getUserInfo.b.bwE().bwG().getUserId());
                }
                aqVar.dK("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.nhY = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bwE() != null && com.baidu.tbadk.getUserInfo.b.bwE().bwG() != null) {
                    aqVar.dK("uid", com.baidu.tbadk.getUserInfo.b.bwE().bwG().getUserId());
                }
                aqVar.dK("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.nhZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bwE() != null && com.baidu.tbadk.getUserInfo.b.bwE().bwG() != null) {
                    aqVar.dK("uid", com.baidu.tbadk.getUserInfo.b.bwE().bwG().getUserId());
                }
                aqVar.dK("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.nia = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bwE() != null && com.baidu.tbadk.getUserInfo.b.bwE().bwG() != null) {
                    aqVar.dK("uid", com.baidu.tbadk.getUserInfo.b.bwE().bwG().getUserId());
                }
                aqVar.dK("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.nib = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nhO.setAlpha(GuidePopupWindow.this.nhN.getScrollY() / 150.0f);
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

    public void TE(String str) {
        this.nhx.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void fG(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nhS = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            fH(list);
        }
    }

    public void G(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = at.cZ(j).length();
        spannableStringBuilder.append((CharSequence) at.cZ(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = at.cZ(j2).length();
        spannableStringBuilder.append((CharSequence) at.cZ(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.nhQ, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nhR, length + 14 + 8, length + 22 + length2, 18);
        this.nhy.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void Ao(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nhQ = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        this.nhR = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundResource(this.mRootView, R.color.cp_mask_b_alpha83);
        ap.setViewTextColor(this.gMY, R.color.cp_cont_a);
        ap.setViewTextColor(this.nhy, R.color.cp_cont_a);
        ap.setBackgroundResource(this.mLine, R.color.cp_border_c_alpha33);
        ap.setViewTextColor(this.lEM, R.color.cp_cont_c);
        ap.setViewTextColor(this.nhz, R.color.cp_cont_a);
        ap.setViewTextColor(this.nhA, R.color.cp_cont_c);
        ap.setViewTextColor(this.nhB, R.color.cp_cont_a);
        ap.setViewTextColor(this.nhC, R.color.cp_cont_c);
        ap.setViewTextColor(this.nhD, R.color.cp_cont_a);
        ap.setViewTextColor(this.nhE, R.color.cp_cont_c);
        ap.setViewTextColor(this.nhF, R.color.cp_cont_a);
        ap.setViewTextColor(this.nhG, R.color.cp_cont_c);
        ap.setViewTextColor(this.nhx, R.color.cp_cont_c);
        ap.setViewTextColor(this.nhM, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.a(this.nhL, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_link_tip_a, R.color.cp_link_tip_a, 1);
        ap.a(this.nhM, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_border_c_alpha50, R.color.cp_border_c_alpha50, 1);
    }

    public void dMT() {
        if (com.baidu.tbadk.getUserInfo.b.bwE() != null && com.baidu.tbadk.getUserInfo.b.bwE().bwG() != null) {
            this.gMY.setText(com.baidu.tbadk.getUserInfo.b.bwE().bwG().getName_show());
        }
    }

    public void dMU() {
        if (com.baidu.tbadk.getUserInfo.b.bwE() != null && com.baidu.tbadk.getUserInfo.b.bwE().bwG() != null) {
            this.nhv.a(com.baidu.tbadk.getUserInfo.b.bwE().bwG());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.nhv.a(userData);
        }
    }

    public void TF(String str) {
        this.nhw.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nhN = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nhN.setScrollChangedListener(this.nib);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nhv = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nhv.setHasPendantStyle();
        this.nhv.setDefalutResid(R.drawable.default_head);
        this.nhv.getHeadView().setIsRound(true);
        this.nhv.getHeadView().setDrawBorder(true);
        this.nhv.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nhv.setShowSimpleIcon(true);
        this.nhw = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.gMY = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nhx = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nhy = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.lEM = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nhH = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nhz = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nhA = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nhI = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nhB = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nhC = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nhJ = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nhD = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nhE = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nhK = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nhF = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nhG = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nhL = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nhL.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pN(R.color.cp_link_tip_a);
        this.nhL.setConfig(cVar);
        this.nhL.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nhM = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pN(R.color.cp_border_c_alpha50);
        this.nhM.setConfig(cVar2);
        this.nhM.setTextSize(R.dimen.tbds42);
        this.nhM.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nhO = this.mRootView.findViewById(R.id.shadow_top);
        this.nhO.setAlpha(0.0f);
        this.nhP = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nhP.setBorderColor(ap.getColor(R.color.cp_mask_c_alpha16));
        this.nhP.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nhP.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dMV();
    }

    private void dMV() {
        this.nhH.setOnClickListener(this.nhV);
        this.nhI.setOnClickListener(this.nhW);
        this.nhJ.setOnClickListener(this.nhX);
        this.nhK.setOnClickListener(this.nhY);
        this.nhL.setOnClickListener(this.nhZ);
        this.nhM.setOnClickListener(this.nia);
    }

    private void fH(final List<String> list) {
        this.nhx.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nhx.setText(GuidePopupWindow.this.fI(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fI(List<String> list) {
        String a2 = a(list, 0, true);
        if (TG(a2) >= this.nhx.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (TG(a3) < this.nhx.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int TG(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nhx.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nhx.getPaint().measureText(str) + 0.5f));
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
        if (this.nhS) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nif;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nif, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nif = i;
        }
    }
}
