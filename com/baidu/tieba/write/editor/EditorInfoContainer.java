package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.f.d;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools Dl;
    private int Dm;
    private boolean fDc;
    private String fVb;
    private LocationInfoWithDelView jPV;
    private StateSwitchView jPW;
    private StateSwitchView jPX;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDc = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.fVb = str;
        ej(context);
        ek(context);
        el(context);
    }

    private void ej(Context context) {
        this.jPV = new LocationInfoWithDelView(context);
        this.jPV.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        this.jPV.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cys() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cyt() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.jPV.hide();
            }
        });
        addView(this.jPV, layoutParams);
    }

    private void ek(Context context) {
        this.jPW = new StateSwitchView(context);
        this.jPW.setId(R.id.view_write_thread_add_title);
        this.jPW.setStateString(getResources().getString(R.string.write_add_title), getResources().getString(R.string.write_hide_title));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        layoutParams.addRule(1, R.id.editor_id_location);
        this.jPW.setLayoutParams(layoutParams);
        this.jPW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.jPW.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.jPW.aHJ();
            }
        });
        addView(this.jPW);
    }

    private void el(Context context) {
        this.jPX = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.jPX.setLayoutParams(layoutParams);
        this.jPX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.fVb)) {
                        TiebaStatic.log(new an("c12608").O("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.fVb)) {
                        TiebaStatic.log(new an("c12608").O("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.jPX.aHJ();
                if ("2".equals(EditorInfoContainer.this.fVb)) {
                    a.br(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.jPX.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.fVb)) {
            this.jPX.setStateString(getResources().getString(R.string.public_to_all), getResources().getString(R.string.public_to_me));
        } else if ("2".equals(this.fVb)) {
            this.jPX.setStateString(getResources().getString(R.string.display_to_home_page), getResources().getString(R.string.display_to_home_page));
            this.jPX.setLeftStateDrawable(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_stroke1_blue_h_svg), new d(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
            this.jPX.setPadding(this.jPX.getPaddingLeft(), 0, 0, 0);
            this.jPX.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds28));
        }
        addView(this.jPX);
    }

    public boolean isPrivacy() {
        return (this.jPX == null || this.jPX.getState() != 0) && this.jPX != null && this.jPX.getState() == 1;
    }

    public void beI() {
        if (this.jPX != null) {
            this.jPX.hideTip();
        }
    }

    public void cyr() {
        if (this.jPW != null) {
            this.jPW.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bq(String str, int i) {
        if ("2".equals(this.fVb)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0538a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0538a
                public void BB(int i2) {
                    EditorInfoContainer.this.jPX.setState(i2 != 1 ? 0 : 1);
                }
            });
        }
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
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    if (aVar2 != null && aVar2.cGJ) {
                        this.jPV.setState(aVar2.state, aVar2.addr);
                        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                            if (!StringUtils.isNull(aVar2.addr)) {
                                setVisibility(0);
                                return;
                            } else {
                                setVisibility(8);
                                return;
                            }
                        }
                        return;
                    }
                    this.jPV.hide();
                    if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case 20:
                this.jPV.hide();
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    setVisibility(8);
                    return;
                }
                return;
            case 21:
                this.jPW.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.fDc) {
            this.fDc = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Dm;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        beI();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.jPW != null) {
            this.jPW.onChangeSkinType(i);
            am.e(this.jPW, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        }
        if (this.jPV != null) {
            this.jPV.onChangeSkinType(i);
        }
        if (this.jPX != null) {
            this.jPX.onChangeSkinType(i);
            if ("1".equals(this.fVb)) {
                am.e(this.jPX, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }
}
