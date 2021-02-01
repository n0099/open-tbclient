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
    private TextView hzG;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private TextView mvk;
    private HeadPendantView nXX;
    private ImageView nXY;
    private TextView nXZ;
    private View.OnClickListener nYA;
    private View.OnClickListener nYB;
    private View.OnClickListener nYC;
    private GuideScrollView.a nYD;
    private TextView nYa;
    private TextView nYb;
    private TextView nYc;
    private TextView nYd;
    private TextView nYe;
    private TextView nYf;
    private TextView nYg;
    private TextView nYh;
    private TextView nYi;
    private RelativeLayout nYj;
    private RelativeLayout nYk;
    private RelativeLayout nYl;
    private RelativeLayout nYm;
    private TBSpecificationBtn nYn;
    private TBSpecificationBtn nYo;
    private GuideScrollView nYp;
    private View nYq;
    private HeadBorder nYr;
    private ForegroundColorSpan nYs;
    private ForegroundColorSpan nYt;
    private boolean nYu;
    private final String nYv;
    private final String nYw;
    private View.OnClickListener nYx;
    private View.OnClickListener nYy;
    private View.OnClickListener nYz;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nYv = "认证：";
        this.nYw = "c13887";
        this.nYx = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
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
        this.nYy = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
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
        this.nYz = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
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
        this.nYA = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
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
        this.nYB = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
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
        this.nYC = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
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
        this.nYD = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nYq.setAlpha(GuidePopupWindow.this.nYp.getScrollY() / 150.0f);
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

    public void UP(String str) {
        this.nXZ.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void gc(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nYu = true;
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
        spannableStringBuilder.setSpan(this.nYs, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nYt, length + 14 + 8, length + 22 + length2, 18);
        this.nYa.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void Ab(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nYs = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        this.nYt = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0609);
        ap.setViewTextColor(this.hzG, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYa, R.color.CAM_X0101);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0616);
        ap.setViewTextColor(this.mvk, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYb, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYc, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYd, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYe, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYf, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYg, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYh, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYi, R.color.CAM_X0108);
        ap.setViewTextColor(this.nXZ, R.color.CAM_X0108);
        ap.setViewTextColor(this.nYo, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.b(this.nYn, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
        ap.b(this.nYo, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
    }

    public void dVX() {
        if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
            this.hzG.setText(com.baidu.tbadk.getUserInfo.b.bCI().bCK().getName_show());
        }
    }

    public void dVY() {
        if (com.baidu.tbadk.getUserInfo.b.bCI() != null && com.baidu.tbadk.getUserInfo.b.bCI().bCK() != null) {
            this.nXX.a(com.baidu.tbadk.getUserInfo.b.bCI().bCK());
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            this.nXX.a(userData);
        }
    }

    public void UQ(String str) {
        this.nXY.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nYp = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nYp.setScrollChangedListener(this.nYD);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nXX = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nXX.setHasPendantStyle();
        this.nXX.setDefalutResid(R.drawable.default_head);
        this.nXX.getHeadView().setIsRound(true);
        this.nXX.getHeadView().setDrawBorder(true);
        this.nXX.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nXX.setShowSimpleIcon(true);
        this.nXY = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.hzG = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nXZ = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nYa = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.mvk = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nYj = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nYb = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nYc = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nYk = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nYd = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nYe = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nYl = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nYf = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nYg = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nYm = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nYh = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nYi = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nYn = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nYn.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pR(R.color.CAM_X0302);
        this.nYn.setConfig(cVar);
        this.nYn.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nYo = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pR(R.color.CAM_X0618);
        this.nYo.setConfig(cVar2);
        this.nYo.setTextSize(R.dimen.tbds42);
        this.nYo.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nYq = this.mRootView.findViewById(R.id.shadow_top);
        this.nYq.setAlpha(0.0f);
        this.nYr = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nYr.setBorderColor(ap.getColor(R.color.CAM_X0614));
        this.nYr.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nYr.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dVZ();
    }

    private void dVZ() {
        this.nYj.setOnClickListener(this.nYx);
        this.nYk.setOnClickListener(this.nYy);
        this.nYl.setOnClickListener(this.nYz);
        this.nYm.setOnClickListener(this.nYA);
        this.nYn.setOnClickListener(this.nYB);
        this.nYo.setOnClickListener(this.nYC);
    }

    private void gd(final List<String> list) {
        this.nXZ.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nXZ.setText(GuidePopupWindow.this.ge(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ge(List<String> list) {
        String a2 = a(list, 0, true);
        if (UR(a2) >= this.nXZ.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (UR(a3) < this.nXZ.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int UR(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nXZ.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nXZ.getPaint().measureText(str) + 0.5f));
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
        if (this.nYu) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nYG;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nYG, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nYG = i;
        }
    }
}
