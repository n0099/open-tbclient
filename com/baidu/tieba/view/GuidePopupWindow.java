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
    private TextView hex;
    private TextView lXw;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private View mLine;
    private View mRootView;
    private HeadPendantView nAY;
    private ImageView nAZ;
    private View.OnClickListener nBA;
    private View.OnClickListener nBB;
    private View.OnClickListener nBC;
    private View.OnClickListener nBD;
    private GuideScrollView.a nBE;
    private TextView nBa;
    private TextView nBb;
    private TextView nBc;
    private TextView nBd;
    private TextView nBe;
    private TextView nBf;
    private TextView nBg;
    private TextView nBh;
    private TextView nBi;
    private TextView nBj;
    private RelativeLayout nBk;
    private RelativeLayout nBl;
    private RelativeLayout nBm;
    private RelativeLayout nBn;
    private TBSpecificationBtn nBo;
    private TBSpecificationBtn nBp;
    private GuideScrollView nBq;
    private View nBr;
    private HeadBorder nBs;
    private ForegroundColorSpan nBt;
    private ForegroundColorSpan nBu;
    private boolean nBv;
    private final String nBw;
    private final String nBx;
    private View.OnClickListener nBy;
    private View.OnClickListener nBz;

    public GuidePopupWindow(Context context) {
        super(context, R.style.dialog);
        this.nBw = "认证：";
        this.nBx = "c13887";
        this.nBy = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forumID", GuidePopupWindow.this.mForumId);
                hashMap.put(TbTitleActivityConfig.FORUM_NAME, GuidePopupWindow.this.mForumName);
                hashMap.put("obj_source", "5");
                hashMap.put("swipeback", false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "BarBroadcastEdit", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAm() != null && com.baidu.tbadk.getUserInfo.b.bAm().bAo() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAm().bAo().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ak("obj_locate", 1);
                TiebaStatic.log(arVar);
            }
        };
        this.nBz = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "RecommendHistoryPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAm() != null && com.baidu.tbadk.getUserInfo.b.bAm().bAo() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAm().bAo().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ak("obj_locate", 4);
                TiebaStatic.log(arVar);
            }
        };
        this.nBA = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "DataCenterPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAm() != null && com.baidu.tbadk.getUserInfo.b.bAm().bAo() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAm().bAo().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ak("obj_locate", 3);
                TiebaStatic.log(arVar);
            }
        };
        this.nBB = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, "ForumSectionPage", hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAm() != null && com.baidu.tbadk.getUserInfo.b.bAm().bAo() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAm().bAo().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ak("obj_locate", 2);
                TiebaStatic.log(arVar);
            }
        };
        this.nBC = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("forum_id", GuidePopupWindow.this.mForumId);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(GuidePopupWindow.this.mContext, OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAm() != null && com.baidu.tbadk.getUserInfo.b.bAm().bAo() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAm().bAo().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ak("obj_locate", 6);
                TiebaStatic.log(arVar);
            }
        };
        this.nBD = new View.OnClickListener() { // from class: com.baidu.tieba.view.GuidePopupWindow.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuidePopupWindow.this.dismiss();
                ar arVar = new ar("c13887");
                if (com.baidu.tbadk.getUserInfo.b.bAm() != null && com.baidu.tbadk.getUserInfo.b.bAm().bAo() != null) {
                    arVar.dR("uid", com.baidu.tbadk.getUserInfo.b.bAm().bAo().getUserId());
                }
                arVar.dR("fid", GuidePopupWindow.this.mForumId);
                arVar.ak("obj_locate", 5);
                TiebaStatic.log(arVar);
            }
        };
        this.nBE = new GuideScrollView.a() { // from class: com.baidu.tieba.view.GuidePopupWindow.8
            @Override // com.baidu.tieba.view.GuideScrollView.a
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                GuidePopupWindow.this.nBr.setAlpha(GuidePopupWindow.this.nBq.getScrollY() / 150.0f);
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

    public void Uf(String str) {
        this.nBa.setText("认证：" + str + getContext().getResources().getString(R.string.guide_popup_window_join_field_bar_owner));
    }

    public void fW(List<String> list) {
        if (list != null) {
            List<String> list2 = null;
            if (list.size() > 3) {
                this.nBv = true;
                list2 = list.subList(0, 3);
            }
            if (list2 != null) {
                list = list2;
            }
            fX(list);
        }
    }

    public void I(long j, long j2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc1));
        int length = au.dx(j).length();
        spannableStringBuilder.append((CharSequence) au.dx(j));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc2));
        int length2 = au.dx(j2).length();
        spannableStringBuilder.append((CharSequence) au.dx(j2));
        spannableStringBuilder.append((CharSequence) this.mContext.getResources().getString(R.string.guide_popup_window_concern_desc3));
        spannableStringBuilder.setSpan(this.nBt, 14, length + 14, 18);
        spannableStringBuilder.setSpan(this.nBu, length + 14 + 8, length + 22 + length2, 18);
        this.nBb.setText(spannableStringBuilder);
    }

    public void setForumId(int i) {
        this.mForumId = String.valueOf(i);
    }

    public void Aq(String str) {
        this.mForumName = str;
    }

    public void onChangeSkinType() {
        this.nBt = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        this.nBu = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302));
        ap.setBackgroundResource(this.mRootView, R.color.CAM_X0609);
        ap.setViewTextColor(this.hex, R.color.CAM_X0101);
        ap.setViewTextColor(this.nBb, R.color.CAM_X0101);
        ap.setBackgroundResource(this.mLine, R.color.CAM_X0616);
        ap.setViewTextColor(this.lXw, R.color.CAM_X0108);
        ap.setViewTextColor(this.nBc, R.color.CAM_X0101);
        ap.setViewTextColor(this.nBd, R.color.CAM_X0108);
        ap.setViewTextColor(this.nBe, R.color.CAM_X0101);
        ap.setViewTextColor(this.nBf, R.color.CAM_X0108);
        ap.setViewTextColor(this.nBg, R.color.CAM_X0101);
        ap.setViewTextColor(this.nBh, R.color.CAM_X0108);
        ap.setViewTextColor(this.nBi, R.color.CAM_X0101);
        ap.setViewTextColor(this.nBj, R.color.CAM_X0108);
        ap.setViewTextColor(this.nBa, R.color.CAM_X0108);
        ap.setViewTextColor(this.nBp, R.color.cp_cont_a_alpha20);
        int dimens = l.getDimens(this.mContext, R.dimen.tbds60);
        ap.a(this.nBo, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0302, R.color.CAM_X0302, 1);
        ap.a(this.nBp, dimens, R.color.CAM_X0611, R.color.CAM_X0611, R.color.CAM_X0618, R.color.CAM_X0618, 1);
    }

    public void dSC() {
        if (com.baidu.tbadk.getUserInfo.b.bAm() != null && com.baidu.tbadk.getUserInfo.b.bAm().bAo() != null) {
            this.hex.setText(com.baidu.tbadk.getUserInfo.b.bAm().bAo().getName_show());
        }
    }

    public void dSD() {
        if (com.baidu.tbadk.getUserInfo.b.bAm() != null && com.baidu.tbadk.getUserInfo.b.bAm().bAo() != null) {
            this.nAY.a(com.baidu.tbadk.getUserInfo.b.bAm().bAo());
        }
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.nAY.a(userData);
        }
    }

    public void Ug(String str) {
        this.nAZ.setImageResource(UtilHelper.getBazhuIconId(str, false));
    }

    private void initView() {
        this.nBq = (GuideScrollView) this.mRootView.findViewById(R.id.guid_popup_window_container);
        this.nBq.setScrollChangedListener(this.nBE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        this.mRootView.startAnimation(alphaAnimation);
        this.nAY = (HeadPendantView) this.mRootView.findViewById(R.id.user_head);
        this.nAY.setHasPendantStyle();
        this.nAY.setDefalutResid(R.drawable.default_head);
        this.nAY.getHeadView().setIsRound(true);
        this.nAY.getHeadView().setDrawBorder(true);
        this.nAY.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nAY.setShowSimpleIcon(true);
        this.nAZ = (ImageView) this.mRootView.findViewById(R.id.user_leavel);
        this.hex = (TextView) this.mRootView.findViewById(R.id.user_name);
        this.nBa = (TextView) this.mRootView.findViewById(R.id.user_tb_list);
        this.nBb = (TextView) this.mRootView.findViewById(R.id.user_tb_concern_info);
        this.mLine = this.mRootView.findViewById(R.id.guid_popup_window_line);
        this.lXw = (TextView) this.mRootView.findViewById(R.id.function_desc);
        this.nBk = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_broadcast);
        this.nBc = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_name);
        this.nBd = (TextView) this.mRootView.findViewById(R.id.personalba_broadcast_digest);
        this.nBl = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_recommend);
        this.nBe = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_name);
        this.nBf = (TextView) this.mRootView.findViewById(R.id.personalba_recommend_digest);
        this.nBm = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_data);
        this.nBg = (TextView) this.mRootView.findViewById(R.id.personalba_data_name);
        this.nBh = (TextView) this.mRootView.findViewById(R.id.personalba_data_digest);
        this.nBn = (RelativeLayout) this.mRootView.findViewById(R.id.personalba_partition);
        this.nBi = (TextView) this.mRootView.findViewById(R.id.personalba_partition_name);
        this.nBj = (TextView) this.mRootView.findViewById(R.id.personalba_partition_digest);
        this.nBo = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_go_away);
        this.nBo.setTextSize(R.dimen.tbds42);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.qG(R.color.CAM_X0302);
        this.nBo.setConfig(cVar);
        this.nBo.setText(this.mContext.getResources().getString(R.string.guide_popup_window_go_away));
        this.nBp = (TBSpecificationBtn) this.mRootView.findViewById(R.id.btn_known);
        com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar2.qG(R.color.CAM_X0618);
        this.nBp.setConfig(cVar2);
        this.nBp.setTextSize(R.dimen.tbds42);
        this.nBp.setText(this.mContext.getResources().getString(R.string.guide_popup_window_known));
        this.nBr = this.mRootView.findViewById(R.id.shadow_top);
        this.nBr.setAlpha(0.0f);
        this.nBs = (HeadBorder) this.mRootView.findViewById(R.id.head_border);
        this.nBs.setBorderColor(ap.getColor(R.color.CAM_X0614));
        this.nBs.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10));
        this.nBs.setRedio(l.getDimens(this.mContext, R.dimen.tbds119));
        dSE();
    }

    private void dSE() {
        this.nBk.setOnClickListener(this.nBy);
        this.nBl.setOnClickListener(this.nBz);
        this.nBm.setOnClickListener(this.nBA);
        this.nBn.setOnClickListener(this.nBB);
        this.nBo.setOnClickListener(this.nBC);
        this.nBp.setOnClickListener(this.nBD);
    }

    private void fX(final List<String> list) {
        this.nBa.post(new Runnable() { // from class: com.baidu.tieba.view.GuidePopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                GuidePopupWindow.this.nBa.setText(GuidePopupWindow.this.fY(list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fY(List<String> list) {
        String a2 = a(list, 0, true);
        if (Uh(a2) >= this.nBa.getWidth()) {
            for (int i = 5; 1 < i; i--) {
                String a3 = a(list, i, false);
                if (Uh(a3) < this.nBa.getWidth()) {
                    return a3;
                }
            }
            return null;
        }
        return a2;
    }

    private int Uh(String str) {
        Float valueOf = Float.valueOf(0.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            valueOf = Float.valueOf(this.nBa.getLetterSpacing());
        }
        return (((int) (valueOf.floatValue() + 0.5f)) * (str.length() - 1)) + ((int) (this.nBa.getPaint().measureText(str) + 0.5f));
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
        if (this.nBv) {
            return sb.toString().substring(0, sb.toString().length() - 4) + getContext().getResources().getString(R.string.guide_popup_window_join_field_omit);
        }
        return sb.toString().substring(0, sb.toString().length() - 4);
    }

    /* loaded from: classes.dex */
    public static class HeadBorder extends View {
        private int nBH;
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
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nBH, this.paint);
        }

        public void setBorderColor(int i) {
            this.paint.setColor(i);
        }

        public void setBorderWidth(float f) {
            this.paint.setStrokeWidth(f);
        }

        public void setRedio(int i) {
            this.nBH = i;
        }
    }
}
