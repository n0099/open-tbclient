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
    private TextView gvu;
    private TextView lgE;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private TBSpecificationBtn mIA;
    private GuideScrollView mIB;
    private View mIC;
    private HeadBorder mIE;
    private ForegroundColorSpan mIF;
    private ForegroundColorSpan mIG;
    private boolean mIH;
    private final String mII;
    private final String mIJ;
    private View.OnClickListener mIK;
    private View.OnClickListener mIL;
    private View.OnClickListener mIM;
    private View.OnClickListener mIN;
    private View.OnClickListener mIO;
    private View.OnClickListener mIP;
    private GuideScrollView.a mIQ;
    private HeadPendantView mIh;
    private ImageView mIi;
    private TextView mIj;
    private TextView mIk;
    private TextView mIl;
    private TextView mIm;
    private TextView mIn;
    private TextView mIo;
    private TextView mIq;
    private TextView mIr;
    private TextView mIt;
    private TextView mIu;
    private RelativeLayout mIv;
    private RelativeLayout mIw;
    private RelativeLayout mIx;
    private RelativeLayout mIy;
    private TBSpecificationBtn mIz;
    private View mLine;
    private View mRootView;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.mII = "认证：";
        this.mIJ = "c13887";
        this.mIK = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsQ() != null && com.baidu.tbadk.getUserInfo.b.bsQ().bsS() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsQ().bsS().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIL = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsQ() != null && com.baidu.tbadk.getUserInfo.b.bsQ().bsS() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsQ().bsS().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIM = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsQ() != null && com.baidu.tbadk.getUserInfo.b.bsQ().bsS() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsQ().bsS().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIN = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsQ() != null && com.baidu.tbadk.getUserInfo.b.bsQ().bsS() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsQ().bsS().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIO = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsQ() != null && com.baidu.tbadk.getUserInfo.b.bsQ().bsS() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsQ().bsS().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIP = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bsQ() != null && com.baidu.tbadk.getUserInfo.b.bsQ().bsS() != null) {
                    aqVar.dD("uid", com.baidu.tbadk.getUserInfo.b.bsQ().bsS().getUserId());
                }
                aqVar.dD("fid", GuidePopupWindow.this.mForumId);
                aqVar.ai("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.mIQ = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.mIC.setAlpha(GuidePopupWindow.this.mIB.getScrollY() / 150.0f);
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
        this.mIj.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void fu(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.mIH = true;
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
        spannableStringBuilder.setSpan(this.mIF, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.mIG, length + 14 + 8, length + 22 + length2, 18);
        this.mIk.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void zh(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.mIF = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        this.mIG = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundResource(this.mRootView, R.color.cp_mask_b_alpha83);
        ap.setViewTextColor(this.gvu, R.color.cp_cont_a);
        ap.setViewTextColor(this.mIk, R.color.cp_cont_a);
        ap.setBackgroundResource(this.mLine, R.color.cp_border_c_alpha33);
        ap.setViewTextColor(this.lgE, R.color.cp_cont_c);
        ap.setViewTextColor(this.mIl, R.color.cp_cont_a);
        ap.setViewTextColor(this.mIm, R.color.cp_cont_c);
        ap.setViewTextColor(this.mIn, R.color.cp_cont_a);
        ap.setViewTextColor(this.mIo, R.color.cp_cont_c);
        ap.setViewTextColor(this.mIq, R.color.cp_cont_a);
        ap.setViewTextColor(this.mIr, R.color.cp_cont_c);
        ap.setViewTextColor(this.mIt, R.color.cp_cont_a);
        ap.setViewTextColor(this.mIu, R.color.cp_cont_c);
        ap.setViewTextColor(this.mIj, R.color.cp_cont_c);
        ap.setViewTextColor(this.mIA, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.a(this.mIz, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_link_tip_a, R.color.cp_link_tip_a, 1);
        ap.a(this.mIA, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_border_c_alpha50, R.color.cp_border_c_alpha50, 1);
    }

    public void dFn() {
        if (com.baidu.tbadk.getUserInfo.b.bsQ() != null && com.baidu.tbadk.getUserInfo.b.bsQ().bsS() != null) {
            this.gvu.setText(com.baidu.tbadk.getUserInfo.b.bsQ().bsS().getName_show());
        }
    }

    public void dFo() {
        if (com.baidu.tbadk.getUserInfo.b.bsQ() != null && com.baidu.tbadk.getUserInfo.b.bsQ().bsS() != null) {
            this.mIh.a(com.baidu.tbadk.getUserInfo.b.bsQ().bsS());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.mIh.a(userData);
        }
    }

    public void Sr(String str) {
        this.mIi.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.mIB = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.mIB.setScrollChangedListener(this.mIQ);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.mIh = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.mIh.setHasPendantStyle();
        this.mIh.setDefalutResid(R.drawable.default_head);
        this.mIh.getHeadView().setIsRound(true);
        this.mIh.getHeadView().setDrawBorder(true);
        this.mIh.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mIh.setShowSimpleIcon(true);
        this.mIi = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.gvu = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.mIj = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.mIk = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.lgE = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.mIv = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.mIl = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.mIm = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.mIw = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.mIn = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.mIo = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.mIx = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.mIq = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.mIr = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.mIy = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.mIt = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.mIu = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.mIz = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.mIz.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pb(R.color.cp_link_tip_a);
        this.mIz.setConfig(cVar);
        this.mIz.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.mIA = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pb(R.color.cp_border_c_alpha50);
        this.mIA.setConfig(cVar2);
        this.mIA.setTextSize(R.dimen.tbds42);
        this.mIA.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.mIC = this.mRootView.findViewById(R.id.shadow_top);
        this.mIC.setAlpha(0.0f);
        this.mIE = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.mIE.setBorderColor(ap.getColor(R.color.cp_mask_c_alpha16));
        this.mIE.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.mIE.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dFp();
    }

    private void dFp() {
        this.mIv.setOnClickListener(this.mIK);
        this.mIw.setOnClickListener(this.mIL);
        this.mIx.setOnClickListener(this.mIM);
        this.mIy.setOnClickListener(this.mIN);
        this.mIz.setOnClickListener(this.mIO);
        this.mIA.setOnClickListener(this.mIP);
    }

    private void fv(final List<String> list) {
        this.mIj.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.mIj.setText(GuidePopupWindow.this.fw(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fw(List<String> list) {
        String a = a(list, 0, true);
        if (Ss(a) >= this.mIj.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a2 = a(list, i, false);
                if (Ss(a2) < this.mIj.getWidth()) {
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
            valueOf = Float.valueOf(this.mIj.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.mIj.getPaint().measureText(str) + 0.5f));
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
        if (this.mIH) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int mIT;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mIT, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.mIT = i;
        }
    }
}
