package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tieba.e;
import com.baidu.tieba.face.b;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PbFullScreenEditorInputView extends EditText {
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

    public void b(com.baidu.tbadk.coreExtra.data.o oVar) {
        if (com.baidu.tieba.face.a.mG(getText().toString()) >= 10) {
            com.baidu.tbadk.core.util.e.Bs().showToast(e.j.too_many_face);
        } else {
            com.baidu.tieba.face.b.b(getContext(), oVar, this);
        }
    }

    public void hq(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    public void ao(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
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

    public void loadData(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.face.b.a(getContext(), str, new b.a() { // from class: com.baidu.tieba.pb.pb.main.PbFullScreenEditorInputView.1
                @Override // com.baidu.tieba.face.b.a
                public void a(SpannableStringBuilder spannableStringBuilder) {
                    PbFullScreenEditorInputView.this.setText(spannableStringBuilder);
                    PbFullScreenEditorInputView.this.setSelection(PbFullScreenEditorInputView.this.getText().length());
                }
            });
        }
    }
}
