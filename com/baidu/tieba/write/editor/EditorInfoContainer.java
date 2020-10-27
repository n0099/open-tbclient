package com.baidu.tieba.write.editor;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.a;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements n {
    private EditorTools abk;
    private int abl;
    private boolean iKq;
    private String jff;
    private String mForumId;
    private String mFrom;
    private LocationInfoView nAU;
    private TBSpecificationBtn nAV;
    private TBSpecificationBtn nAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void onChange(boolean z);
    }

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iKq = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.tbds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.tbds117)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.jff = str;
        ga(context);
        gb(context);
        gc(context);
    }

    public void gI(long j) {
        int left = this.nAU.getLeft();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.nAU, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.nAW, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat);
        animatorSet.setDuration(j / 4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nAW.getStyleConfig()).pY(R.color.cp_link_tip_a);
                EditorInfoContainer.this.nAW.getStyleConfig().pU(R.color.cp_link_tip_a);
                ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nAU.getLocationBtn().getStyleConfig()).pY(R.color.cp_link_tip_a);
                EditorInfoContainer.this.nAU.getLocationBtn().getStyleConfig().pU(R.color.cp_link_tip_a);
                animatorSet.start();
            }
        }, 1000L);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            int count = 0;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                this.count++;
                if (this.count > 1) {
                    EditorInfoContainer.this.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nAW.getStyleConfig()).qa(R.color.cp_cont_b);
                            EditorInfoContainer.this.nAW.getStyleConfig().pU(R.color.cp_cont_e);
                            ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.nAU.getLocationBtn().getStyleConfig()).qa(R.color.cp_cont_b);
                            EditorInfoContainer.this.nAU.getLocationBtn().getStyleConfig().pU(R.color.cp_cont_e);
                        }
                    }, 0L);
                } else {
                    EditorInfoContainer.this.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            animatorSet.start();
                        }
                    }, 1500L);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, final a aVar) {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("show_privacy_dialog", false);
        if (i == 1 || z) {
            if (aVar != null) {
                aVar.onChange(true);
                return;
            }
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("show_privacy_dialog", true);
        BaseActivity baseActivity = (BaseActivity) context;
        final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(baseActivity);
        aVar2.iM(false);
        aVar2.a((String) null, (a.b) null);
        aVar2.b((String) null, (a.b) null);
        aVar2.op(6);
        CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
        customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.write_privacy_dialog_title));
        customPrivacyDialogView.setMessageTextViewColor(ap.getColor(R.color.cp_cont_j));
        customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.write_privacy_dialog_close));
        customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.write_privacy_dialog_open));
        customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    TiebaStatic.log(new aq("c13805").aj("obj_locate", 2));
                    aVar.onChange(true);
                }
                aVar2.dismiss();
            }
        });
        customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    TiebaStatic.log(new aq("c13805").aj("obj_locate", 1));
                    aVar.onChange(false);
                }
                aVar2.dismiss();
            }
        });
        aVar2.bb(customPrivacyDialogView);
        aVar2.b(baseActivity.getPageContext()).bmC();
        TiebaStatic.log(new aq("c13804"));
    }

    private void ga(Context context) {
        this.nAU = new LocationInfoView(context);
        this.nAU.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.tbds31);
        this.nAU.setLocationClickListener(new LocationInfoView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.5
            @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
            public void bxp() {
                TiebaStatic.log(new aq("c12612").aj("obj_locate", 3));
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        addView(this.nAU, layoutParams);
    }

    private void gb(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(1, R.id.editor_id_location);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.qa(R.color.cp_cont_b);
        bVar.pU(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        bVar.a(R.drawable.ic_icon_pure_post_topic16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.nAW = new TBSpecificationBtn(context);
        this.nAW.setConfig(bVar);
        this.nAW.setTextSize(R.dimen.tbds32);
        this.nAW.setText(getContext().getString(R.string.add_topic));
        this.nAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(43, -1, null));
            }
        });
        addView(this.nAW, layoutParams);
    }

    private void gc(final Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(11);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.qa(R.color.cp_cont_b);
        bVar.pU(R.color.cp_link_tip_a);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.nAV = new TBSpecificationBtn(context);
        this.nAV.setConfig(bVar);
        this.nAV.setTextSize(R.dimen.tbds32);
        Le(0);
        this.nAV.setLayoutParams(layoutParams);
        this.nAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12612").aj("obj_locate", ((Integer) EditorInfoContainer.this.nAV.eTf).intValue() == 0 ? 11 : 12));
                EditorInfoContainer.this.a(context, ((Integer) EditorInfoContainer.this.nAV.eTf).intValue(), new a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7.1
                    @Override // com.baidu.tieba.write.editor.EditorInfoContainer.a
                    public void onChange(boolean z) {
                        if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                            if ("1".equals(EditorInfoContainer.this.jff)) {
                                TiebaStatic.log(new aq("c12608").aj("obj_locate", 6));
                            } else if ("2".equals(EditorInfoContainer.this.jff)) {
                                TiebaStatic.log(new aq("c12608").aj("obj_locate", 5));
                            }
                        }
                        if (z) {
                            int i = ((Integer) EditorInfoContainer.this.nAV.eTf).intValue() == 0 ? 1 : 0;
                            EditorInfoContainer.this.Le(i);
                            if ("2".equals(EditorInfoContainer.this.jff)) {
                                com.baidu.tieba.write.editor.a.bP(EditorInfoContainer.this.mForumId, i);
                            }
                        }
                    }
                });
            }
        });
        addView(this.nAV);
    }

    public boolean isPrivacy() {
        if (this.nAV == null || ((Integer) this.nAV.eTf).intValue() != 0) {
            return this.nAV != null && ((Integer) this.nAV.eTf).intValue() == 1;
        }
        return false;
    }

    public void cpK() {
    }

    public void dRh() {
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bO(String str, int i) {
        if ("2".equals(this.jff)) {
            this.mForumId = str;
            com.baidu.tieba.write.editor.a.a(str, i, new a.InterfaceC0862a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.8
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0862a
                public void Lf(int i2) {
                    EditorInfoContainer.this.Le(i2);
                }
            });
        }
    }

    public void Ld(int i) {
        if ("2".equals(this.jff)) {
            Le(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le(int i) {
        this.nAV.setText(getResources().getString(R.string.public_to_all));
        this.nAV.getStyleConfig().a(i == 0 ? R.drawable.icon_pure_post_chosen16 : R.drawable.icon_pure_chose_post16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.nAV.getStyleConfig().pU(i == 0 ? R.color.cp_link_tip_a : R.color.cp_cont_e);
        this.nAV.eTf = Integer.valueOf(i);
    }

    public void yp(boolean z) {
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar == null) {
            return;
        }
        switch (aVar.code) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 46:
            case 49:
            default:
                return;
            case 19:
                if (this.nAU != null) {
                    if (aVar.data instanceof com.baidu.tbadk.editortools.d.a) {
                        com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.nAU.setState(aVar2.state, aVar2.addr);
                        return;
                    }
                    this.nAU.setState(0, null);
                    return;
                }
                return;
            case 20:
                if (this.nAU != null) {
                    this.nAU.setState(0, null);
                    return;
                }
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
            case 57:
                b(new com.baidu.tbadk.editortools.a(58, -1, false));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.iKq) {
            this.iKq = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abl;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        cpK();
        setVisibility(8);
    }

    public void yq(boolean z) {
        if (this.nAW != null) {
            this.nAW.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        if (this.nAU != null) {
            this.nAU.onChangeSkinType(i);
        }
        if (this.nAV != null) {
            this.nAV.bqd();
        }
        if (this.nAW != null) {
            this.nAW.bqd();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }
}
