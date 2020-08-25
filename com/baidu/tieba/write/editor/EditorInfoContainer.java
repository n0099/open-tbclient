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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements n {
    private EditorTools aay;
    private int aaz;
    private boolean ibN;
    private String iwr;
    private String mForumId;
    private String mFrom;
    private LocationInfoView mOG;
    private TBSpecificationBtn mOH;
    private TBSpecificationBtn mOI;

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
        this.ibN = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.tbds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.tbds117)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.iwr = str;
        fM(context);
        fN(context);
        fO(context);
    }

    public void fZ(long j) {
        int left = this.mOG.getLeft();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mOG, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mOI, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat);
        animatorSet.setDuration(j / 4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.mOI.getStyleConfig()).pb(R.color.cp_link_tip_a);
                EditorInfoContainer.this.mOI.getStyleConfig().oY(R.color.cp_link_tip_a);
                ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.mOG.getLocationBtn().getStyleConfig()).pb(R.color.cp_link_tip_a);
                EditorInfoContainer.this.mOG.getLocationBtn().getStyleConfig().oY(R.color.cp_link_tip_a);
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
                            ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.mOI.getStyleConfig()).pd(R.color.cp_cont_b);
                            EditorInfoContainer.this.mOI.getStyleConfig().oY(R.color.cp_cont_e);
                            ((com.baidu.tbadk.core.view.commonBtn.b) EditorInfoContainer.this.mOG.getLocationBtn().getStyleConfig()).pd(R.color.cp_cont_b);
                            EditorInfoContainer.this.mOG.getLocationBtn().getStyleConfig().oY(R.color.cp_cont_e);
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
        boolean z = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("show_privacy_dialog", false);
        if (i == 1 || z) {
            if (aVar != null) {
                aVar.onChange(true);
                return;
            }
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("show_privacy_dialog", true);
        BaseActivity baseActivity = (BaseActivity) context;
        new com.baidu.tbadk.core.dialog.a(baseActivity).zz(context.getString(R.string.write_privacy_dialog_title)).a(context.getString(R.string.write_privacy_dialog_open), new a.b() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar != null) {
                    TiebaStatic.log(new aq("c13805").ai("obj_locate", 1));
                    aVar.onChange(false);
                }
                aVar2.dismiss();
            }
        }).b(context.getString(R.string.write_privacy_dialog_close), new a.b() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar != null) {
                    TiebaStatic.log(new aq("c13805").ai("obj_locate", 2));
                    aVar.onChange(true);
                }
                aVar2.dismiss();
            }
        }).nv(R.color.cp_cont_b).nu(R.color.cp_link_tip_a).b(baseActivity.getPageContext()).bhg();
        TiebaStatic.log(new aq("c13804"));
    }

    private void fM(Context context) {
        this.mOG = new LocationInfoView(context);
        this.mOG.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.tbds31);
        this.mOG.setLocationClickListener(new LocationInfoView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.5
            @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
            public void brJ() {
                TiebaStatic.log(new aq("c12612").ai("obj_locate", 3));
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        addView(this.mOG, layoutParams);
    }

    private void fN(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(1, R.id.editor_id_location);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pd(R.color.cp_cont_b);
        bVar.oY(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        bVar.a(R.drawable.ic_icon_pure_post_topic16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.mOI = new TBSpecificationBtn(context);
        this.mOI.setConfig(bVar);
        this.mOI.setTextSize(R.dimen.tbds32);
        this.mOI.setText(getContext().getString(R.string.add_topic));
        this.mOI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(43, -1, null));
            }
        });
        addView(this.mOI, layoutParams);
    }

    private void fO(final Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(11);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pd(R.color.cp_cont_b);
        bVar.oY(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.mOH = new TBSpecificationBtn(context);
        this.mOH.setConfig(bVar);
        this.mOH.setTextSize(R.dimen.tbds32);
        JB(0);
        this.mOH.setLayoutParams(layoutParams);
        this.mOH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new aq("c12612").ai("obj_locate", ((Integer) EditorInfoContainer.this.mOH.ewr).intValue() == 0 ? 11 : 12));
                EditorInfoContainer.this.a(context, ((Integer) EditorInfoContainer.this.mOH.ewr).intValue(), new a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7.1
                    @Override // com.baidu.tieba.write.editor.EditorInfoContainer.a
                    public void onChange(boolean z) {
                        if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                            if ("1".equals(EditorInfoContainer.this.iwr)) {
                                TiebaStatic.log(new aq("c12608").ai("obj_locate", 6));
                            } else if ("2".equals(EditorInfoContainer.this.iwr)) {
                                TiebaStatic.log(new aq("c12608").ai("obj_locate", 5));
                            }
                        }
                        if (z) {
                            int i = ((Integer) EditorInfoContainer.this.mOH.ewr).intValue() == 0 ? 1 : 0;
                            EditorInfoContainer.this.JB(i);
                            if ("2".equals(EditorInfoContainer.this.iwr)) {
                                com.baidu.tieba.write.editor.a.bN(EditorInfoContainer.this.mForumId, i);
                            }
                        }
                    }
                });
            }
        });
        addView(this.mOH);
    }

    public boolean isPrivacy() {
        if (this.mOH == null || ((Integer) this.mOH.ewr).intValue() != 0) {
            return this.mOH != null && ((Integer) this.mOH.ewr).intValue() == 1;
        }
        return false;
    }

    public void cfP() {
    }

    public void dGk() {
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bM(String str, int i) {
        if ("2".equals(this.iwr)) {
            this.mForumId = str;
            com.baidu.tieba.write.editor.a.a(str, i, new a.InterfaceC0832a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.8
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0832a
                public void JC(int i2) {
                    EditorInfoContainer.this.JB(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JB(int i) {
        this.mOH.setText(i == 0 ? getResources().getString(R.string.public_to_all) : getResources().getString(R.string.public_to_me));
        this.mOH.getStyleConfig().a(i == 0 ? R.drawable.ic_icon_pure_post_open16_svg : R.drawable.ic_icon_pure_post_hide16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.mOH.ewr = Integer.valueOf(i);
    }

    public void xg(boolean z) {
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
                if (this.mOG != null) {
                    if (aVar.data instanceof com.baidu.tbadk.editortools.d.a) {
                        com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.mOG.setState(aVar2.state, aVar2.addr);
                        return;
                    }
                    this.mOG.setState(0, null);
                    return;
                }
                return;
            case 20:
                if (this.mOG != null) {
                    this.mOG.setState(0, null);
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
        if (this.ibN) {
            this.ibN = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaz;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        cfP();
        setVisibility(8);
    }

    public void xh(boolean z) {
        if (this.mOI != null) {
            this.mOI.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        if (this.mOG != null) {
            this.mOG.onChangeSkinType(i);
        }
        if (this.mOH != null) {
            this.mOH.bkF();
        }
        if (this.mOI != null) {
            this.mOI.bkF();
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }
}
