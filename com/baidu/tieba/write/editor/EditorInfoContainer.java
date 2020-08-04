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
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements m {
    private EditorTools ZS;
    private int ZT;
    private boolean hNI;
    private String iim;
    private String mForumId;
    private String mFrom;
    private LocationInfoView mwt;
    private TBSpecificationBtn mwu;
    private TBSpecificationBtn mwv;

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
        this.hNI = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.tbds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.tbds117)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.iim = str;
        fz(context);
        fA(context);
        fB(context);
    }

    public void fN(long j) {
        int left = this.mwt.getLeft();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mwt, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mwv, "translationX", left + 10, (float) (left - 10), left + 10, (float) (left - 10));
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat2, ofFloat);
        animatorSet.setDuration(j / 4);
        postDelayed(new Runnable() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ((c) EditorInfoContainer.this.mwv.getStyleConfig()).mV(R.color.cp_link_tip_a);
                EditorInfoContainer.this.mwv.getStyleConfig().mS(R.color.cp_link_tip_a);
                ((c) EditorInfoContainer.this.mwt.getLocationBtn().getStyleConfig()).mV(R.color.cp_link_tip_a);
                EditorInfoContainer.this.mwt.getLocationBtn().getStyleConfig().mS(R.color.cp_link_tip_a);
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
                            ((c) EditorInfoContainer.this.mwv.getStyleConfig()).mX(R.color.cp_cont_b);
                            EditorInfoContainer.this.mwv.getStyleConfig().mS(R.color.cp_cont_e);
                            ((c) EditorInfoContainer.this.mwt.getLocationBtn().getStyleConfig()).mX(R.color.cp_cont_b);
                            EditorInfoContainer.this.mwt.getLocationBtn().getStyleConfig().mS(R.color.cp_cont_e);
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
        boolean z = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("show_privacy_dialog", false);
        if (i == 1 || z) {
            if (aVar != null) {
                aVar.onChange(true);
                return;
            }
            return;
        }
        com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("show_privacy_dialog", true);
        BaseActivity baseActivity = (BaseActivity) context;
        new com.baidu.tbadk.core.dialog.a(baseActivity).xl(context.getString(R.string.write_privacy_dialog_title)).a(context.getString(R.string.write_privacy_dialog_open), new a.b() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar != null) {
                    TiebaStatic.log(new ap("c13805").ah("obj_locate", 1));
                    aVar.onChange(false);
                }
                aVar2.dismiss();
            }
        }).b(context.getString(R.string.write_privacy_dialog_close), new a.b() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar != null) {
                    TiebaStatic.log(new ap("c13805").ah("obj_locate", 2));
                    aVar.onChange(true);
                }
                aVar2.dismiss();
            }
        }).lp(R.color.cp_cont_b).lo(R.color.cp_link_tip_a).b(baseActivity.getPageContext()).aYL();
        TiebaStatic.log(new ap("c13804"));
    }

    private void fz(Context context) {
        this.mwt = new LocationInfoView(context);
        this.mwt.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.tbds31);
        this.mwt.setLocationClickListener(new LocationInfoView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.5
            @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
            public void biX() {
                TiebaStatic.log(new ap("c12612").ah("obj_locate", 3));
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }
        });
        addView(this.mwt, layoutParams);
    }

    private void fA(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(1, R.id.editor_id_location);
        c cVar = new c();
        cVar.mX(R.color.cp_cont_b);
        cVar.mS(R.color.cp_cont_e);
        cVar.aS(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        cVar.k(R.drawable.ic_icon_pure_post_topic16_svg, 0, true);
        this.mwv = new TBSpecificationBtn(context);
        this.mwv.setConfig(cVar);
        this.mwv.setTextSize(R.dimen.tbds32);
        this.mwv.setText(getContext().getString(R.string.add_topic));
        this.mwv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(43, -1, null));
            }
        });
        addView(this.mwv, layoutParams);
    }

    private void fB(final Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.addRule(11);
        c cVar = new c();
        cVar.mX(R.color.cp_cont_b);
        cVar.mS(R.color.cp_cont_e);
        cVar.aS(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.mwu = new TBSpecificationBtn(context);
        this.mwu.setConfig(cVar);
        this.mwu.setTextSize(R.dimen.tbds32);
        He(0);
        this.mwu.setLayoutParams(layoutParams);
        this.mwu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new ap("c12612").ah("obj_locate", ((Integer) EditorInfoContainer.this.mwu.emo).intValue() == 0 ? 11 : 12));
                EditorInfoContainer.this.a(context, ((Integer) EditorInfoContainer.this.mwu.emo).intValue(), new a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.7.1
                    @Override // com.baidu.tieba.write.editor.EditorInfoContainer.a
                    public void onChange(boolean z) {
                        if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                            if ("1".equals(EditorInfoContainer.this.iim)) {
                                TiebaStatic.log(new ap("c12608").ah("obj_locate", 6));
                            } else if ("2".equals(EditorInfoContainer.this.iim)) {
                                TiebaStatic.log(new ap("c12608").ah("obj_locate", 5));
                            }
                        }
                        if (z) {
                            int i = ((Integer) EditorInfoContainer.this.mwu.emo).intValue() == 0 ? 1 : 0;
                            EditorInfoContainer.this.He(i);
                            if ("2".equals(EditorInfoContainer.this.iim)) {
                                com.baidu.tieba.write.editor.a.bI(EditorInfoContainer.this.mForumId, i);
                            }
                        }
                    }
                });
            }
        });
        addView(this.mwu);
    }

    public boolean isPrivacy() {
        if (this.mwu == null || ((Integer) this.mwu.emo).intValue() != 0) {
            return this.mwu != null && ((Integer) this.mwu.emo).intValue() == 1;
        }
        return false;
    }

    public void bVC() {
    }

    public void duO() {
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bH(String str, int i) {
        if ("2".equals(this.iim)) {
            this.mForumId = str;
            com.baidu.tieba.write.editor.a.a(str, i, new a.InterfaceC0779a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.8
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0779a
                public void Hf(int i2) {
                    EditorInfoContainer.this.He(i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He(int i) {
        this.mwu.setText(i == 0 ? getResources().getString(R.string.public_to_all) : getResources().getString(R.string.public_to_me));
        this.mwu.getStyleConfig().k(i == 0 ? R.drawable.ic_icon_pure_post_open16_svg : R.drawable.ic_icon_pure_post_hide16_svg, 0, true);
        this.mwu.emo = Integer.valueOf(i);
    }

    public void wr(boolean z) {
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
                if (this.mwt != null) {
                    if (aVar.data instanceof com.baidu.tbadk.editortools.d.a) {
                        com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        this.mwt.setState(aVar2.state, aVar2.addr);
                        return;
                    }
                    this.mwt.setState(0, null);
                    return;
                }
                return;
            case 20:
                if (this.mwt != null) {
                    this.mwt.setState(0, null);
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

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.hNI) {
            this.hNI = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        bVC();
        setVisibility(8);
    }

    public void ws(boolean z) {
        if (this.mwv != null) {
            this.mwv.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        if (this.mwt != null) {
            this.mwt.onChangeSkinType(i);
        }
        if (this.mwu != null) {
            this.mwu.bci();
        }
        if (this.mwv != null) {
            this.mwv.bci();
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }
}
