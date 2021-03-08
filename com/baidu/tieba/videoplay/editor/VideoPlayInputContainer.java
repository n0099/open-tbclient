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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import com.baidu.tieba.write.j;
import java.util.regex.Matcher;
/* loaded from: classes7.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    private EditorTools ael;
    private int aem;
    private int aln;
    private TextView bWx;
    private boolean fEt;
    private boolean fEu;
    private boolean fEv;
    private int fEw;
    private LinearLayout fFC;
    private EditText fFy;
    private ImageView jlG;
    private View mBottomLine;

    public VideoPlayInputContainer(Context context) {
        this(context, null);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEt = false;
        this.fEu = true;
        this.fEv = true;
        this.fEw = -1;
        this.aln = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        this.fFC = new LinearLayout(getContext());
        this.fFC.setOrientation(0);
        this.fFC.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fFC, new LinearLayout.LayoutParams(-1, -2));
        hb(context);
        fm(context);
        fl(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void hb(Context context) {
        this.jlG = new ImageView(context);
        this.jlG.setEnabled(true);
        this.jlG.setPadding(0, 0, l.getDimens(context, R.dimen.tbds30), l.getDimens(context, R.dimen.tbds24));
        this.jlG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(1, 5, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        this.fFC.addView(this.jlG, layoutParams);
    }

    private void fm(Context context) {
        this.fFy = new EditText(context);
        this.fFy.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fFy.setMaxLines(4);
        this.fFy.setGravity(16);
        this.fFy.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fFy.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fFy, R.drawable.edittext_cursor);
        this.fFy.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fFy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fFy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!VideoPlayInputContainer.this.fEv) {
                    VideoPlayInputContainer.this.fEv = true;
                    if (VideoPlayInputContainer.this.fEw != -1) {
                        VideoPlayInputContainer.this.fFy.setSelection(VideoPlayInputContainer.this.fEw);
                        VideoPlayInputContainer.this.fEw = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, VideoPlayInputContainer.this.fFy.getText().toString()));
                }
                VideoPlayInputContainer.this.bWx.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                VideoPlayInputContainer.this.dVX();
            }
        });
        this.fFy.setHint(context.getString(R.string.reply_something));
        this.fFy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    VideoPlayInputContainer.this.fFy.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.fFC.addView(this.fFy, layoutParams);
    }

    private void fl(Context context) {
        this.bWx = new TextView(context);
        this.bWx.setGravity(17);
        this.bWx.setIncludeFontPadding(false);
        this.bWx.setEnabled(false);
        this.bWx.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
        this.bWx.setText(R.string.send_replay);
        this.bWx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, l.getDimens(context, R.dimen.tbds18));
        layoutParams.gravity = 80;
        this.fFC.addView(this.bWx, layoutParams);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fFy.getSelectionStart() > 0) {
                        String substring = this.fFy.getText().toString().substring(0, this.fFy.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iUh.matcher(substring);
                        if (matcher.find()) {
                            this.fFy.getText().delete(this.fFy.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fFy.getSelectionStart());
                            return;
                        }
                        this.fFy.getText().delete(this.fFy.getSelectionStart() - 1, this.fFy.getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        this.fFy.setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fFy.setText((CharSequence) null);
                            return;
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.videoplay.editor.VideoPlayInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    VideoPlayInputContainer.this.fFy.setText(spannableStringBuilder);
                                    VideoPlayInputContainer.this.fFy.setSelection(VideoPlayInputContainer.this.fFy.getText().length());
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
                        this.fFy.setText((CharSequence) null);
                    }
                    this.bWx.setEnabled(false);
                    dVX();
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof u)) {
                        u uVar = (u) aVar.data;
                        if (uVar.bwy() == EmotionGroupType.NET_SUG) {
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
            String obj = this.fFy.getText().toString();
            if (this.fEu && com.baidu.tieba.face.a.JC(obj) >= 10 && getContext() != null) {
                e.brZ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fFy);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fEt || uVar.bwy() == EmotionGroupType.LOCAL) {
            String obj = this.fFy.getText().toString();
            if (this.fEu && com.baidu.tieba.face.a.JC(obj) >= 10 && getContext() != null) {
                e.brZ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fFy);
            }
        }
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
        if (this.fFy != null) {
            this.fFy.setFocusable(true);
            this.fFy.setFocusableInTouchMode(true);
            this.fFy.requestFocus();
            l.showSoftKeyPad(getContext(), this.fFy);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.aln = i;
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.fFy, R.color.CAM_X0106, 2, i);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fFy, R.drawable.edittext_cursor);
            this.fFy.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
        } else {
            j.h(this.fFy, R.drawable.edittext_cursor_1);
            this.fFy.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        }
        dVX();
        ap.setImageResource(this.jlG, R.drawable.pbeditor_face_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVX() {
        if (this.bWx.isEnabled()) {
            ap.setViewTextColor(this.bWx, R.color.CAM_X0302, 1, this.aln);
        } else {
            ap.setViewTextColor(this.bWx, R.color.CAM_X0107, 1);
        }
    }

    public EditText getInputView() {
        return this.fFy;
    }
}
