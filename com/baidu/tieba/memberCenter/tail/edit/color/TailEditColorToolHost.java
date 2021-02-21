package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class TailEditColorToolHost extends NoPressedLinearLayout implements n {
    private EditorTools acR;
    private int acS;
    private View.OnClickListener fml;
    private c lsE;
    private a lsH;
    private e lsI;

    public TailEditColorToolHost(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext.getPageActivity());
        this.acS = 0;
        this.fml = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.color.TailEditColorToolHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    TailEditColorToolHost.this.lsE.tD(bVar.getColor());
                    TailEditColorToolHost.this.lsH.notifyDataSetChanged();
                    TailEditColorToolHost.this.acR.b(new com.baidu.tbadk.editortools.a(26, -1, bVar.getColor()));
                }
            }
        };
        e(tbPageContext, str);
    }

    private void e(TbPageContext<?> tbPageContext, String str) {
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tail_edit_color, (ViewGroup) this, true);
        this.lsI = new e(this);
        this.lsE = new c(tbPageContext);
        this.lsE.tD(str);
        this.lsH = new a(tbPageContext, this.lsE, this.fml);
        this.lsI.a(this.lsH);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
