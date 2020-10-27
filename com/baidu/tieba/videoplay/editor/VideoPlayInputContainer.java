package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.support.annotation.Nullable;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes24.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools abk;
    private int abl;
    private int ajq;
    private TextView bHv;
    private boolean fje;
    private boolean fjf;
    private boolean fjg;
    private int fjh;
    private EditText fkh;
    private LinearLayout fkl;
    private ImageView iES;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fje = false;
        this.fjf = true;
        this.fjg = true;
        this.fjh = -1;
        this.ajq = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fkl = new LinearLayout(getContext());
        this.fkl.setOrientation(0);
        this.fkl.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fkl, new LinearLayout.LayoutParams(-1, -2));
        fZ(context);
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fZ(Context context) {
        this.iES = new ImageView(context);
        this.iES.setEnabled(true);
        this.iES.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.iES.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fkl.addView(this.iES, layoutParams);
    }

    private void ep(Context context) {
        this.fkh = new EditText(context);
        this.fkh.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fkh.setMaxLines(4);
        this.fkh.setGravity(16);
        this.fkh.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fkh.setBackgroundResource(R.color.common_color_10022);
        g(this.fkh, R.drawable.edittext_cursor);
        this.fkh.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fkh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fkh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.fjg) {
                    VideoPlayInputContainer.this.fjg = true;
                    if (VideoPlayInputContainer.this.fjh != -1) {
                        VideoPlayInputContainer.this.fkh.setSelection(VideoPlayInputContainer.this.fjh);
                        VideoPlayInputContainer.this.fjh = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fkh.getText().toString()));
                }
                VideoPlayInputContainer.this.bHv.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dPN();
            }
        });
        this.fkh.setHint(context.getString(R.string.reply_something));
        this.fkh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fkh.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fkl.addView(this.fkh, layoutParams);
    }

    private void g(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void eo(Context context) {
        this.bHv = new TextView(context);
        this.bHv.setGravity(17);
        this.bHv.setIncludeFontPadding(false);
        this.bHv.setEnabled(false);
        this.bHv.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bHv.setText(R.string.send_replay);
        this.bHv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fkl.addView(this.bHv, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fkh.getSelectionStart() > 0) {
                        String substring = this.fkh.getText().toString().substring(0, this.fkh.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.f3int.matcher(substring);
                        if (matcher.find()) {
                            this.fkh.getText().delete(this.fkh.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fkh.getSelectionStart());
                            return;
                        }
                        this.fkh.getText().delete(this.fkh.getSelectionStart() - 1, this.fkh.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fkh.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fkh.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fkh.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fkh.setSelection(VideoPlayInputContainer.this.fkh.getText().length());
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
                        this.fkh.setText((CharSequence) null);
                    }
                    this.bHv.setEnabled(false);
                    dPN();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.bsm() == EmotionGroupType.NET_SUG) {
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
            String obj = this.fkh.getText().toString();
            if (this.fjf && com.baidu.tieba.face.a.Jn(obj) >= 10 && getContext() != null) {
                e.bnP().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fkh);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fje || uVar.bsm() == EmotionGroupType.LOCAL) {
            String obj = this.fkh.getText().toString();
            if (this.fjf && com.baidu.tieba.face.a.Jn(obj) >= 10 && getContext() != null) {
                e.bnP().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fkh);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abl;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fkh != null) {
            this.fkh.setFocusable(true);
            this.fkh.setFocusableInTouchMode(true);
            this.fkh.requestFocus();
            l.showSoftKeyPad(getContext(), this.fkh);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.ajq = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fkh, R.color.cp_cont_f, 2, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            g(this.fkh, R.drawable.edittext_cursor);
            this.fkh.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_d));
        } else {
            g(this.fkh, R.drawable.edittext_cursor_1);
            this.fkh.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        dPN();
        ap.setImageResource(this.iES, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPN() {
        if (this.bHv.isEnabled()) {
            ap.setViewTextColor(this.bHv, R.color.cp_link_tip_a, 1, this.ajq);
        } else {
            ap.setViewTextColor(this.bHv, R.color.cp_cont_j, 1);
        }
    }

    public EditText getInputView() {
        return this.fkh;
    }
}
