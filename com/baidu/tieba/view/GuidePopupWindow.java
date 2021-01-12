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
    private TextView hvw;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private TextView mmj;
    private HeadPendantView nNS;
    private ImageView nNT;
    private TextView nNU;
    private TextView nNV;
    private TextView nNW;
    private TextView nNX;
    private TextView nNY;
    private TextView nNZ;
    private TextView nOa;
    private TextView nOb;
    private TextView nOc;
    private TextView nOd;
    private RelativeLayout nOe;
    private RelativeLayout nOf;
    private RelativeLayout nOg;
    private RelativeLayout nOh;
    private TBSpecificationBtn nOi;
    private TBSpecificationBtn nOj;
    private GuideScrollView nOk;
    private View nOl;
    private HeadBorder nOm;
    private ForegroundColorSpan nOn;
    private ForegroundColorSpan nOo;
    private boolean nOp;
    private final String nOq;
    private final String nOr;
    private View.OnClickListener nOs;
    private View.OnClickListener nOt;
    private View.OnClickListener nOu;
    private View.OnClickListener nOv;
    private View.OnClickListener nOw;
    private View.OnClickListener nOx;
    private GuideScrollView.a nOy;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nOq = "认证：";
        this.nOr = "c13887";
        this.nOs = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCq() != null && com.baidu.tbadk.getUserInfo.b.bCq().bCs() != null) {
                    aqVar.dW("uid", com.baidu.tbadk.getUserInfo.b.bCq().bCs().getUserId());
                }
                aqVar.dW("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.nOt = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCq() != null && com.baidu.tbadk.getUserInfo.b.bCq().bCs() != null) {
                    aqVar.dW("uid", com.baidu.tbadk.getUserInfo.b.bCq().bCs().getUserId());
                }
                aqVar.dW("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.nOu = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCq() != null && com.baidu.tbadk.getUserInfo.b.bCq().bCs() != null) {
                    aqVar.dW("uid", com.baidu.tbadk.getUserInfo.b.bCq().bCs().getUserId());
                }
                aqVar.dW("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.nOv = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCq() != null && com.baidu.tbadk.getUserInfo.b.bCq().bCs() != null) {
                    aqVar.dW("uid", com.baidu.tbadk.getUserInfo.b.bCq().bCs().getUserId());
                }
                aqVar.dW("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.nOw = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCq() != null && com.baidu.tbadk.getUserInfo.b.bCq().bCs() != null) {
                    aqVar.dW("uid", com.baidu.tbadk.getUserInfo.b.bCq().bCs().getUserId());
                }
                aqVar.dW("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.nOx = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bCq() != null && com.baidu.tbadk.getUserInfo.b.bCq().bCs() != null) {
                    aqVar.dW("uid", com.baidu.tbadk.getUserInfo.b.bCq().bCs().getUserId());
                }
                aqVar.dW("fid", GuidePopupWindow.this.mForumId);
                aqVar.an("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.nOy = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nOl.setAlpha(GuidePopupWindow.this.nOk.getScrollY() / 150.0f);
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

    public void TQ(String str) {
        this.nNU.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void ge(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nOp = true;
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
        spannableStringBuilder.setSpan(this.nOn, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nOo, length + 14 + 8, length + 22 + length2, 18);
        this.nNV.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void zK(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nOn = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302));
        this.nOo = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302));
        ao.setBackgroundResource(this.mRootView, R.color.CAM_X0609);
        ao.setViewTextColor(this.hvw, R.color.CAM_X0101);
        ao.setViewTextColor(this.nNV, R.color.CAM_X0101);
        ao.setBackgroundResource(this.mLine, R.color.CAM_X0616);
        ao.setViewTextColor(this.mmj, R.color.CAM_X0108);
        ao.setViewTextColor(this.nNW, R.color.CAM_X0101);
        ao.setViewTextColor(this.nNX, R.color.CAM_X0108);
        ao.setViewTextColor(this.nNY, R.color.CAM_X0101);
        ao.setViewTextColor(this.nNZ, R.color.CAM_X0108);
        ao.setViewTextColor(this.nOa, R.color.CAM_X0101);
        ao.setViewTextColor(this.nOb, R.color.CAM_X0108);
        ao.setViewTextColor(this.nOc, R.color.CAM_X0101);
        ao.setViewTextColor(this.nOd, R.color.CAM_X0108);
        ao.setViewTextColor(this.nNU, R.color.CAM_X0108);
        ao.setViewTextColor(this.nOj, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ao.b(this.nOi, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
        ao.b(this.nOj, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
    }

    public void dTJ() {
        if (com.baidu.tbadk.getUserInfo.b.bCq() != null && com.baidu.tbadk.getUserInfo.b.bCq().bCs() != null) {
            this.hvw.setText(com.baidu.tbadk.getUserInfo.b.bCq().bCs().getName_show());
        }
    }

    public void dTK() {
        if (com.baidu.tbadk.getUserInfo.b.bCq() != null && com.baidu.tbadk.getUserInfo.b.bCq().bCs() != null) {
            this.nNS.a(com.baidu.tbadk.getUserInfo.b.bCq().bCs());
        }
    }

    public void e(UserData userData) {
        if (userData != null) {
            this.nNS.a(userData);
        }
    }

    public void TR(String str) {
        this.nNT.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nOk = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nOk.setScrollChangedListener(this.nOy);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nNS = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nNS.setHasPendantStyle();
        this.nNS.setDefalutResid(R.drawable.default_head);
        this.nNS.getHeadView().setIsRound(true);
        this.nNS.getHeadView().setDrawBorder(true);
        this.nNS.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nNS.setShowSimpleIcon(true);
        this.nNT = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.hvw = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nNU = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nNV = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.mmj = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nOe = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nNW = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nNX = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nOf = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nNY = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nNZ = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nOg = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nOa = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nOb = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nOh = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nOc = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nOd = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nOi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nOi.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pM(R.color.CAM_X0302);
        this.nOi.setConfig(cVar);
        this.nOi.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nOj = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pM(R.color.CAM_X0618);
        this.nOj.setConfig(cVar2);
        this.nOj.setTextSize(R.dimen.tbds42);
        this.nOj.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nOl = this.mRootView.findViewById(R.id.shadow_top);
        this.nOl.setAlpha(0.0f);
        this.nOm = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nOm.setBorderColor(ao.getColor(R.color.CAM_X0614));
        this.nOm.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nOm.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dTL();
    }

    private void dTL() {
        this.nOe.setOnClickListener(this.nOs);
        this.nOf.setOnClickListener(this.nOt);
        this.nOg.setOnClickListener(this.nOu);
        this.nOh.setOnClickListener(this.nOv);
        this.nOi.setOnClickListener(this.nOw);
        this.nOj.setOnClickListener(this.nOx);
    }

    private void gf(final List<String> list) {
        this.nNU.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nNU.setText(GuidePopupWindow.this.gg(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gg(List<String> list) {
        String a2 = a(list, 0, true);
        if (TS(a2) >= this.nNU.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (TS(a3) < this.nNU.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int TS(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nNU.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nNU.getPaint().measureText(str) + 0.5f));
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
        if (this.nOp) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nOB;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nOB, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nOB = i;
        }
    }
}
