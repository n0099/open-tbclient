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
    private EditorTools CJ;
    private int CK;
    private boolean fCl;
    private String fUk;
    private LocationInfoWithDelView jPe;
    private StateSwitchView jPf;
    private StateSwitchView jPg;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCl = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.fUk = str;
        ej(context);
        ek(context);
        el(context);
    }

    private void ej(Context context) {
        this.jPe = new LocationInfoWithDelView(context);
        this.jPe.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        this.jPe.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cyq() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cyr() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.jPe.hide();
            }
        });
        addView(this.jPe, layoutParams);
    }

    private void ek(Context context) {
        this.jPf = new StateSwitchView(context);
        this.jPf.setId(R.id.view_write_thread_add_title);
        this.jPf.setStateString(getResources().getString(R.string.write_add_title), getResources().getString(R.string.write_hide_title));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        layoutParams.addRule(1, R.id.editor_id_location);
        this.jPf.setLayoutParams(layoutParams);
        this.jPf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.jPf.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.jPf.aHH();
            }
        });
        addView(this.jPf);
    }

    private void el(Context context) {
        this.jPg = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.jPg.setLayoutParams(layoutParams);
        this.jPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.fUk)) {
                        TiebaStatic.log(new an("c12608").O("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.fUk)) {
                        TiebaStatic.log(new an("c12608").O("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.jPg.aHH();
                if ("2".equals(EditorInfoContainer.this.fUk)) {
                    a.br(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.jPg.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.fUk)) {
            this.jPg.setStateString(getResources().getString(R.string.public_to_all), getResources().getString(R.string.public_to_me));
        } else if ("2".equals(this.fUk)) {
            this.jPg.setStateString(getResources().getString(R.string.display_to_home_page), getResources().getString(R.string.display_to_home_page));
            this.jPg.setLeftStateDrawable(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_stroke1_blue_h_svg), new d(R.drawable.icon_pure_stroke1_n_svg, R.color.cp_cont_f));
            this.jPg.setPadding(this.jPg.getPaddingLeft(), 0, 0, 0);
            this.jPg.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds28));
        }
        addView(this.jPg);
    }

    public boolean isPrivacy() {
        return (this.jPg == null || this.jPg.getState() != 0) && this.jPg != null && this.jPg.getState() == 1;
    }

    public void beG() {
        if (this.jPg != null) {
            this.jPg.hideTip();
        }
    }

    public void cyp() {
        if (this.jPf != null) {
            this.jPf.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bq(String str, int i) {
        if ("2".equals(this.fUk)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0533a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0533a
                public void BA(int i2) {
                    EditorInfoContainer.this.jPg.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.cFS) {
                        this.jPe.setState(aVar2.state, aVar2.addr);
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
                    this.jPe.hide();
                    if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case 20:
                this.jPe.hide();
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    setVisibility(8);
                    return;
                }
                return;
            case 21:
                this.jPf.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.fCl) {
            this.fCl = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.CK;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        beG();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.jPf != null) {
            this.jPf.onChangeSkinType(i);
            am.e(this.jPf, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        }
        if (this.jPe != null) {
            this.jPe.onChangeSkinType(i);
        }
        if (this.jPg != null) {
            this.jPg.onChangeSkinType(i);
            if ("1".equals(this.fUk)) {
                am.e(this.jPg, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }
}
