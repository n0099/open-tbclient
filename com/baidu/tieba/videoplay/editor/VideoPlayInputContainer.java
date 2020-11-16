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
/* loaded from: classes23.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools abp;
    private int abq;
    private int ajv;
    private TextView bLq;
    private boolean fod;
    private boolean foe;
    private boolean fof;
    private int fog;
    private EditText fpg;
    private LinearLayout fpk;
    private ImageView iLC;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fod = false;
        this.foe = true;
        this.fof = true;
        this.fog = -1;
        this.ajv = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fpk = new LinearLayout(getContext());
        this.fpk.setOrientation(0);
        this.fpk.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fpk, new LinearLayout.LayoutParams(-1, -2));
        fY(context);
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void fY(Context context) {
        this.iLC = new ImageView(context);
        this.iLC.setEnabled(true);
        this.iLC.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.iLC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fpk.addView(this.iLC, layoutParams);
    }

    private void ep(Context context) {
        this.fpg = new EditText(context);
        this.fpg.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fpg.setMaxLines(4);
        this.fpg.setGravity(16);
        this.fpg.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fpg.setBackgroundResource(R.color.common_color_10022);
        g(this.fpg, R.drawable.edittext_cursor);
        this.fpg.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fpg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fpg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.fof) {
                    VideoPlayInputContainer.this.fof = true;
                    if (VideoPlayInputContainer.this.fog != -1) {
                        VideoPlayInputContainer.this.fpg.setSelection(VideoPlayInputContainer.this.fog);
                        VideoPlayInputContainer.this.fog = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fpg.getText().toString()));
                }
                VideoPlayInputContainer.this.bLq.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dSo();
            }
        });
        this.fpg.setHint(context.getString(R.string.reply_something));
        this.fpg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fpg.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fpk.addView(this.fpg, layoutParams);
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
        this.bLq = new TextView(context);
        this.bLq.setGravity(17);
        this.bLq.setIncludeFontPadding(false);
        this.bLq.setEnabled(false);
        this.bLq.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bLq.setText(R.string.send_replay);
        this.bLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fpk.addView(this.bLq, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fpg.getSelectionStart() > 0) {
                        String substring = this.fpg.getText().toString().substring(0, this.fpg.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iue.matcher(substring);
                        if (matcher.find()) {
                            this.fpg.getText().delete(this.fpg.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fpg.getSelectionStart());
                            return;
                        }
                        this.fpg.getText().delete(this.fpg.getSelectionStart() - 1, this.fpg.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fpg.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fpg.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fpg.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fpg.setSelection(VideoPlayInputContainer.this.fpg.getText().length());
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
                        this.fpg.setText((CharSequence) null);
                    }
                    this.bLq.setEnabled(false);
                    dSo();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.buc() == EmotionGroupType.NET_SUG) {
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
            String obj = this.fpg.getText().toString();
            if (this.foe && com.baidu.tieba.face.a.Jf(obj) >= 10 && getContext() != null) {
                e.bpC().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fpg);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fod || uVar.buc() == EmotionGroupType.LOCAL) {
            String obj = this.fpg.getText().toString();
            if (this.foe && com.baidu.tieba.face.a.Jf(obj) >= 10 && getContext() != null) {
                e.bpC().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fpg);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abq = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abq;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fpg != null) {
            this.fpg.setFocusable(true);
            this.fpg.setFocusableInTouchMode(true);
            this.fpg.requestFocus();
            l.showSoftKeyPad(getContext(), this.fpg);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.ajv = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.fpg, R.color.CAM_X0106, 2, i);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            g(this.fpg, R.drawable.edittext_cursor);
            this.fpg.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            g(this.fpg, R.drawable.edittext_cursor_1);
            this.fpg.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        }
        dSo();
        ap.setImageResource(this.iLC, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSo() {
        if (this.bLq.isEnabled()) {
            ap.setViewTextColor(this.bLq, R.color.CAM_X0302, 1, this.ajv);
        } else {
            ap.setViewTextColor(this.bLq, R.color.CAM_X0107, 1);
        }
    }

    public EditText getInputView() {
        return this.fpg;
    }
}
