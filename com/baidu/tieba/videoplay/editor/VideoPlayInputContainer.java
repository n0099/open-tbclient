package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import com.baidu.tieba.write.j;
import java.util.regex.Matcher;
/* loaded from: classes8.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools acZ;
    private int ada;
    private int akW;
    private TextView bWc;
    private boolean fFn;
    private boolean fFo;
    private boolean fFp;
    private int fFq;
    private EditText fGr;
    private LinearLayout fGv;
    private ImageView jiK;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFn = false;
        this.fFo = true;
        this.fFp = true;
        this.fFq = -1;
        this.akW = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fGv = new LinearLayout(getContext());
        this.fGv.setOrientation(0);
        this.fGv.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fGv, new LinearLayout.LayoutParams(-1, -2));
        hb(context);
        fq(context);
        fp(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void hb(Context context) {
        this.jiK = new ImageView(context);
        this.jiK.setEnabled(true);
        this.jiK.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.jiK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fGv.addView(this.jiK, layoutParams);
    }

    private void fq(Context context) {
        this.fGr = new EditText(context);
        this.fGr.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fGr.setMaxLines(4);
        this.fGr.setGravity(16);
        this.fGr.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fGr.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fGr, R.drawable.edittext_cursor);
        this.fGr.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fGr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fGr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.fFp) {
                    VideoPlayInputContainer.this.fFp = true;
                    if (VideoPlayInputContainer.this.fFq != -1) {
                        VideoPlayInputContainer.this.fGr.setSelection(VideoPlayInputContainer.this.fFq);
                        VideoPlayInputContainer.this.fFq = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fGr.getText().toString()));
                }
                VideoPlayInputContainer.this.bWc.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dXm();
            }
        });
        this.fGr.setHint(context.getString(R.string.reply_something));
        this.fGr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fGr.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fGv.addView(this.fGr, layoutParams);
    }

    private void fp(Context context) {
        this.bWc = new TextView(context);
        this.bWc.setGravity(17);
        this.bWc.setIncludeFontPadding(false);
        this.bWc.setEnabled(false);
        this.bWc.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bWc.setText(R.string.send_replay);
        this.bWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fGv.addView(this.bWc, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fGr.getSelectionStart() > 0) {
                        String substring = this.fGr.getText().toString().substring(0, this.fGr.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iRk.matcher(substring);
                        if (matcher.find()) {
                            this.fGr.getText().delete(this.fGr.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fGr.getSelectionStart());
                            return;
                        }
                        this.fGr.getText().delete(this.fGr.getSelectionStart() - 1, this.fGr.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fGr.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fGr.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fGr.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fGr.setSelection(VideoPlayInputContainer.this.fGr.getText().length());
                                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    VideoPlayInputContainer.this.requestFocus();
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.fGr.setText((CharSequence) null);
                    }
                    this.bWc.setEnabled(false);
                    dXm();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.bzW() == EmotionGroupType.NET_SUG) {
                            a(uVar);
                            return;
                        } else {
                            b(uVar);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fGr.getText().toString();
            if (this.fFo && com.baidu.tieba.face.a.JT(obj) >= 10 && getContext() != null) {
                e.bvy().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fGr);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fFn || uVar.bzW() == EmotionGroupType.LOCAL) {
            String obj = this.fGr.getText().toString();
            if (this.fFo && com.baidu.tieba.face.a.JT(obj) >= 10 && getContext() != null) {
                e.bvy().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fGr);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        if (this.fGr != null) {
            this.fGr.setFocusable(true);
            this.fGr.setFocusableInTouchMode(true);
            this.fGr.requestFocus();
            l.showSoftKeyPad(getContext(), this.fGr);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.akW = i;
        ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
        ao.setViewTextColor(this.fGr, R.color.CAM_X0106, 2, i);
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fGr, R.drawable.edittext_cursor);
            this.fGr.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            j.h(this.fGr, R.drawable.edittext_cursor_1);
            this.fGr.setHintTextColor(ao.getColor(i, R.color.CAM_X0109));
        }
        dXm();
        ao.setImageResource(this.jiK, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXm() {
        if (this.bWc.isEnabled()) {
            ao.setViewTextColor(this.bWc, R.color.CAM_X0302, 1, this.akW);
        } else {
            ao.setViewTextColor(this.bWc, R.color.CAM_X0107, 1);
        }
    }

    public EditText getInputView() {
        return this.fGr;
    }
}
