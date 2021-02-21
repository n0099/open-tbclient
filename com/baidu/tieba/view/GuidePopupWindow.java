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
    private TextView hzU;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private TextView mvz;
    private TextView nYA;
    private TextView nYB;
    private TextView nYC;
    private TextView nYD;
    private TextView nYE;
    private TextView nYF;
    private TextView nYG;
    private TextView nYH;
    private TextView nYI;
    private RelativeLayout nYJ;
    private RelativeLayout nYK;
    private RelativeLayout nYL;
    private RelativeLayout nYM;
    private TBSpecificationBtn nYN;
    private TBSpecificationBtn nYO;
    private GuideScrollView nYP;
    private View nYQ;
    private HeadBorder nYR;
    private ForegroundColorSpan nYS;
    private ForegroundColorSpan nYT;
    private boolean nYU;
    private final String nYV;
    private final String nYW;
    private View.OnClickListener nYX;
    private View.OnClickListener nYY;
    private View.OnClickListener nYZ;
    private HeadPendantView nYx;
    private ImageView nYy;
    private TextView nYz;
    private View.OnClickListener nZa;
    private View.OnClickListener nZb;
    private View.OnClickListener nZc;
    private GuideScrollView.a nZd;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nYV = "认证：";
        this.nYW = "c13887";
        this.nYX = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCI().bCK().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ap("obj_locate", 1);
                TiebaStatic.log(arVar);
            }
        };
        this.nYY = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCI().bCK().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ap("obj_locate", 4);
                TiebaStatic.log(arVar);
            }
        };
        this.nYZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCI().bCK().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ap("obj_locate", 3);
                TiebaStatic.log(arVar);
            }
        };
        this.nZa = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCI().bCK().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ap("obj_locate", 2);
                TiebaStatic.log(arVar);
            }
        };
        this.nZb = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCI().bCK().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ap("obj_locate", 6);
                TiebaStatic.log(arVar);
            }
        };
        this.nZc = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bCI().bCK().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ap("obj_locate", 5);
                TiebaStatic.log(arVar);
            }
        };
        this.nZd = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nYQ.setAlpha(GuidePopupWindow.this.nYP.getScrollY() / 150.0f);
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

    public void Vb(String str) {
        this.nYz.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void gc(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nYU = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            gd(list);
        }
    }

    public void O(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = au.ec(j).length();
        spannableStringBuilder.append((CharSequence) au.ec(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = au.ec(j2).length();
        spannableStringBuilder.append((CharSequence) au.ec(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.nYS, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nYT, length + 14 + 8, length + 22 + length2, 18);
        this.nYA.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void Ab(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nYS = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        this.nYT = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0609);
        ap.setViewTextColor(this.hzU, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYA, R.color.CAM_X0101);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0616);
        ap.setViewTextColor(this.mvz, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYB, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYC, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYD, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYE, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYF, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYG, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYH, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYI, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYz, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYO, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.b(this.nYN, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
        ap.b(this.nYO, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
    }

    public void dWf() {
        if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
            this.hzU.setText(com.baidu.tbadk.getUserInfo.b.bCI().bCK().getName_show());
        }
    }

    public void dWg() {
        if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
            this.nYx.a(com.baidu.tbadk.getUserInfo.b.bCI().bCK());
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            this.nYx.a(userData);
        }
    }

    public void Vc(String str) {
        this.nYy.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nYP = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nYP.setScrollChangedListener(this.nZd);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nYx = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nYx.setHasPendantStyle();
        this.nYx.setDefalutResid(R.drawable.default_head);
        this.nYx.getHeadView().setIsRound(true);
        this.nYx.getHeadView().setDrawBorder(true);
        this.nYx.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nYx.setShowSimpleIcon(true);
        this.nYy = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.hzU = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nYz = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nYA = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.mvz = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nYJ = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nYB = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nYC = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nYK = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nYD = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nYE = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nYL = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nYF = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nYG = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nYM = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nYH = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nYI = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nYN = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nYN.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pR(R.color.CAM_X0302);
        this.nYN.setConfig(cVar);
        this.nYN.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nYO = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pR(R.color.CAM_X0618);
        this.nYO.setConfig(cVar2);
        this.nYO.setTextSize(R.dimen.tbds42);
        this.nYO.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nYQ = this.mRootView.findViewById(R.id.shadow_top);
        this.nYQ.setAlpha(0.0f);
        this.nYR = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nYR.setBorderColor(ap.getColor(R.color.CAM_X0614));
        this.nYR.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nYR.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dWh();
    }

    private void dWh() {
        this.nYJ.setOnClickListener(this.nYX);
        this.nYK.setOnClickListener(this.nYY);
        this.nYL.setOnClickListener(this.nYZ);
        this.nYM.setOnClickListener(this.nZa);
        this.nYN.setOnClickListener(this.nZb);
        this.nYO.setOnClickListener(this.nZc);
    }

    private void gd(final List<String> list) {
        this.nYz.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nYz.setText(GuidePopupWindow.this.ge(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ge(List<String> list) {
        String a2 = a(list, 0, true);
        if (Vd(a2) >= this.nYz.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (Vd(a3) < this.nYz.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int Vd(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nYz.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nYz.getPaint().measureText(str) + 0.5f));
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
        if (this.nYU) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nZg;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nZg, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nZg = i;
        }
    }
}
