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
    private TextView gYM;
    private TextView lRi;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private HeadPendantView ntW;
    private ImageView ntX;
    private TextView ntY;
    private TextView ntZ;
    private View.OnClickListener nuA;
    private View.OnClickListener nuB;
    private View.OnClickListener nuC;
    private GuideScrollView.a nuD;
    private TextView nua;
    private TextView nub;
    private TextView nuc;
    private TextView nud;
    private TextView nue;
    private TextView nuf;
    private TextView nug;
    private TextView nuh;
    private RelativeLayout nui;
    private RelativeLayout nuj;
    private RelativeLayout nuk;
    private RelativeLayout nul;
    private TBSpecificationBtn nun;
    private TBSpecificationBtn nuo;
    private GuideScrollView nup;
    private View nuq;
    private HeadBorder nur;
    private ForegroundColorSpan nus;
    private ForegroundColorSpan nut;
    private boolean nuu;
    private final String nuv;
    private final String nuw;
    private View.OnClickListener nux;
    private View.OnClickListener nuy;
    private View.OnClickListener nuz;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nuv = "认证：";
        this.nuw = "c13887";
        this.nux = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.byx() != null && com.baidu.tbadk.getUserInfo.b.byx().byz() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.byx().byz().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 1);
                TiebaStatic.log(aqVar);
            }
        };
        this.nuy = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.byx() != null && com.baidu.tbadk.getUserInfo.b.byx().byz() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.byx().byz().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 4);
                TiebaStatic.log(aqVar);
            }
        };
        this.nuz = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.byx() != null && com.baidu.tbadk.getUserInfo.b.byx().byz() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.byx().byz().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 3);
                TiebaStatic.log(aqVar);
            }
        };
        this.nuA = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.byx() != null && com.baidu.tbadk.getUserInfo.b.byx().byz() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.byx().byz().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 2);
                TiebaStatic.log(aqVar);
            }
        };
        this.nuB = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.byx() != null && com.baidu.tbadk.getUserInfo.b.byx().byz() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.byx().byz().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 6);
                TiebaStatic.log(aqVar);
            }
        };
        this.nuC = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                aq aqVar = new aq("c13887");
                if (com.baidu.tbadk.getUserInfo.b.byx() != null && com.baidu.tbadk.getUserInfo.b.byx().byz() != null) {
                    aqVar.dR("uid", com.baidu.tbadk.getUserInfo.b.byx().byz().getUserId());
                }
                aqVar.dR("fid", GuidePopupWindow.this.mForumId);
                aqVar.aj("obj_locate", 5);
                TiebaStatic.log(aqVar);
            }
        };
        this.nuD = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nuq.setAlpha(GuidePopupWindow.this.nup.getScrollY() / 150.0f);
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

    public void Ud(String str) {
        this.ntY.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void fO(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nuu = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            fP(list);
        }
    }

    public void H(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = at.db(j).length();
        spannableStringBuilder.append((CharSequence) at.db(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = at.db(j2).length();
        spannableStringBuilder.append((CharSequence) at.db(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.nus, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nut, length + 14 + 8, length + 22 + length2, 18);
        this.ntZ.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void AH(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nus = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        this.nut = new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a));
        ap.setBackgroundResource(this.mRootView, R.color.cp_mask_b_alpha83);
        ap.setViewTextColor(this.gYM, R.color.cp_cont_a);
        ap.setViewTextColor(this.ntZ, R.color.cp_cont_a);
        ap.setBackgroundResource(this.mLine, R.color.cp_border_c_alpha33);
        ap.setViewTextColor(this.lRi, R.color.cp_cont_c);
        ap.setViewTextColor(this.nua, R.color.cp_cont_a);
        ap.setViewTextColor(this.nub, R.color.cp_cont_c);
        ap.setViewTextColor(this.nuc, R.color.cp_cont_a);
        ap.setViewTextColor(this.nud, R.color.cp_cont_c);
        ap.setViewTextColor(this.nue, R.color.cp_cont_a);
        ap.setViewTextColor(this.nuf, R.color.cp_cont_c);
        ap.setViewTextColor(this.nug, R.color.cp_cont_a);
        ap.setViewTextColor(this.nuh, R.color.cp_cont_c);
        ap.setViewTextColor(this.ntY, R.color.cp_cont_c);
        ap.setViewTextColor(this.nuo, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.a(this.nun, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_link_tip_a, R.color.cp_link_tip_a, 1);
        ap.a(this.nuo, dimens, R.color.cp_mask_b, R.color.cp_mask_b, R.color.cp_border_c_alpha50, R.color.cp_border_c_alpha50, 1);
    }

    public void dQb() {
        if (com.baidu.tbadk.getUserInfo.b.byx() != null && com.baidu.tbadk.getUserInfo.b.byx().byz() != null) {
            this.gYM.setText(com.baidu.tbadk.getUserInfo.b.byx().byz().getName_show());
        }
    }

    public void dQc() {
        if (com.baidu.tbadk.getUserInfo.b.byx() != null && com.baidu.tbadk.getUserInfo.b.byx().byz() != null) {
            this.ntW.a(com.baidu.tbadk.getUserInfo.b.byx().byz());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.ntW.a(userData);
        }
    }

    public void Ue(String str) {
        this.ntX.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nup = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nup.setScrollChangedListener(this.nuD);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.ntW = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.ntW.setHasPendantStyle();
        this.ntW.setDefalutResid(R.drawable.default_head);
        this.ntW.getHeadView().setIsRound(true);
        this.ntW.getHeadView().setDrawBorder(true);
        this.ntW.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ntW.setShowSimpleIcon(true);
        this.ntX = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.gYM = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.ntY = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.ntZ = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.lRi = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nui = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nua = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nub = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nuj = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nuc = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nud = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nuk = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nue = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nuf = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nul = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nug = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nuh = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nun = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nun.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.pY(R.color.cp_link_tip_a);
        this.nun.setConfig(cVar);
        this.nun.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nuo = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.pY(R.color.cp_border_c_alpha50);
        this.nuo.setConfig(cVar2);
        this.nuo.setTextSize(R.dimen.tbds42);
        this.nuo.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nuq = this.mRootView.findViewById(R.id.shadow_top);
        this.nuq.setAlpha(0.0f);
        this.nur = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nur.setBorderColor(ap.getColor(R.color.cp_mask_c_alpha16));
        this.nur.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nur.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dQd();
    }

    private void dQd() {
        this.nui.setOnClickListener(this.nux);
        this.nuj.setOnClickListener(this.nuy);
        this.nuk.setOnClickListener(this.nuz);
        this.nul.setOnClickListener(this.nuA);
        this.nun.setOnClickListener(this.nuB);
        this.nuo.setOnClickListener(this.nuC);
    }

    private void fP(final List<String> list) {
        this.ntY.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.ntY.setText(GuidePopupWindow.this.fQ(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fQ(List<String> list) {
        String a2 = a(list, 0, true);
        if (Uf(a2) >= this.ntY.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (Uf(a3) < this.ntY.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int Uf(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.ntY.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.ntY.getPaint().measureText(str) + 0.5f));
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
        if (this.nuu) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nuG;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nuG, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nuG = i;
        }
    }
}
