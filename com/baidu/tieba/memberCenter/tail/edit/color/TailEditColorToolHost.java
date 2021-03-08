package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class TailEditColorToolHost extends NoPressedLinearLayout implements n {
    private EditorTools ael;
    private int aem;
    private View.OnClickListener fnL;
    private c luH;
    private a luK;
    private e luL;

    public TailEditColorToolHost(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext.getPageActivity());
        this.aem = 0;
        this.fnL = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.color.TailEditColorToolHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    TailEditColorToolHost.this.luH.tK(bVar.getColor());
                    TailEditColorToolHost.this.luK.notifyDataSetChanged();
                    TailEditColorToolHost.this.ael.b(new com.baidu.tbadk.editortools.a(26, -1, bVar.getColor()));
                }
            }
        };
        e(tbPageContext, str);
    }

    private void e(TbPageContext<?> tbPageContext, String str) {
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tail_edit_color, (ViewGroup) this, true);
        this.luL = new e(this);
        this.luH = new c(tbPageContext);
        this.luH.tK(str);
        this.luK = new a(tbPageContext, this.luH, this.fnL);
        this.luL.a(this.luK);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aem = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aem;
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
