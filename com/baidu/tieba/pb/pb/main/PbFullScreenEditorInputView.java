package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class PbFullScreenEditorInputView extends SpanGroupEditText {
    public PbFullScreenEditorInputView(Context context) {
        super(context);
        init();
    }

    public PbFullScreenEditorInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PbFullScreenEditorInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
    }

    public void b(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (com.baidu.tieba.face.a.IO(getText().toString()) >= 10) {
            com.baidu.tbadk.core.util.e.blW().showToast(R.string.too_many_face);
        } else {
            com.baidu.tieba.face.b.b(getContext(), uVar, this);
        }
    }

    public void Dc(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    public void aX(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append(UgcConstant.AT_RULE_TAG);
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    getText().insert(getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void Kr(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.face.b.a(getContext(), str, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorInputView.1
                @Override // com.baidu.tieba.face.b.a
                public void b(SpannableStringBuilder spannableStringBuilder) {
                    PbFullScreenEditorInputView.this.setText(spannableStringBuilder);
                    PbFullScreenEditorInputView.this.setSelection(PbFullScreenEditorInputView.this.getText().length());
                }
            });
        }
    }

    public void fN(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.face.b.a(getContext(), str, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorInputView.2
                @Override // com.baidu.tieba.face.b.a
                public void b(SpannableStringBuilder spannableStringBuilder) {
                    PbFullScreenEditorInputView.this.setHint(spannableStringBuilder);
                }
            });
        }
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.tieba.face.b.a(getContext(), str2, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorInputView.3
                @Override // com.baidu.tieba.face.b.a
                public void b(SpannableStringBuilder spannableStringBuilder) {
                    PbFullScreenEditorInputView.this.setText(spannableStringBuilder);
                    PbFullScreenEditorInputView.this.setSelection(PbFullScreenEditorInputView.this.getText().length());
                }
            });
        }
    }
}
