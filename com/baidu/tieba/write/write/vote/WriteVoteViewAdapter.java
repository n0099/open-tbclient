package com.baidu.tieba.write.write.vote;

import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.z0.i0;
import java.util.List;
/* loaded from: classes5.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22609a;

    /* renamed from: b  reason: collision with root package name */
    public List<WriteVoteItemData> f22610b;

    /* renamed from: d  reason: collision with root package name */
    public f f22612d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22611c = false;

    /* renamed from: e  reason: collision with root package name */
    public TextView.OnEditorActionListener f22613e = new a(this);

    /* loaded from: classes5.dex */
    public class a implements TextView.OnEditorActionListener {
        public a(WriteVoteViewAdapter writeVoteViewAdapter) {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            View focusSearch;
            if (i != 5 || (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) == null) {
                return true;
            }
            focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22614e;

        public b(int i) {
            this.f22614e = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteVoteViewAdapter.this.f22612d != null) {
                WriteVoteViewAdapter.this.f22612d.a(this.f22614e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteVoteViewAdapter.this.f22612d != null) {
                WriteVoteViewAdapter.this.f22612d.b();
                WriteVoteViewAdapter.this.f22611c = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22617a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22618b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f22619c;

        public d(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            this.f22617a = (TextView) view.findViewById(R.id.vote_add_item);
            this.f22618b = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.f22619c = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EditText f22620a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22621b;

        /* renamed from: c  reason: collision with root package name */
        public g f22622c;

        /* loaded from: classes5.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e eVar = e.this;
                    eVar.f22620a.addTextChangedListener(eVar.f22622c);
                    return;
                }
                e eVar2 = e.this;
                eVar2.f22620a.removeTextChangedListener(eVar2.f22622c);
            }
        }

        public e(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            this.f22620a = (EditText) view.findViewById(R.id.vote_item);
            this.f22621b = (ImageView) view.findViewById(R.id.img_delete);
            this.f22622c = new g(this);
            this.f22620a.setOnEditorActionListener(writeVoteViewAdapter.f22613e);
        }

        public void b(int i) {
            this.f22622c.a(i);
            this.f22620a.setOnFocusChangeListener(new a());
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i);

        void b();

        void c(WriteVoteItemData writeVoteItemData, int i);
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final e f22624e;

        /* renamed from: f  reason: collision with root package name */
        public int f22625f;

        public g(e eVar) {
            this.f22624e = eVar;
        }

        public void a(int i) {
            this.f22625f = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                obj = "";
            }
            String replace = obj.replace(" ", "");
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            writeVoteItemData.setId(this.f22625f + 1);
            if (i0.d(replace) > 28) {
                WriteVoteViewAdapter.this.f22609a.showToast(String.format(WriteVoteViewAdapter.this.f22609a.getString(R.string.write_vote_toast), 14));
            }
            String m = i0.m(replace, 28);
            if (!m.equals(editable.toString())) {
                this.f22624e.f22620a.setText(m);
                this.f22624e.f22620a.setSelection(m.length());
            }
            writeVoteItemData.setText(m);
            WriteVoteViewAdapter.this.f22612d.c(writeVoteItemData, this.f22625f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        this.f22609a = tbPageContext;
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f22609a.getResources().getDimension(R.dimen.tbds10));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
        gradientDrawable.setStroke(l.g(this.f22609a.getPageActivity(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0603));
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            eVar.f22620a.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            eVar.f22620a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            eVar.f22620a.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(eVar.f22621b, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            SkinManager.setViewTextColor(dVar.f22617a, R.color.CAM_X0302);
            dVar.f22619c.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(dVar.f22618b, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void g(f fVar) {
        this.f22612d = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<WriteVoteItemData> list = this.f22610b;
        if (list == null) {
            return 0;
        }
        if (list.size() < 20) {
            return this.f22610b.size() + 1;
        }
        return 20;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return !h(i) ? 1 : 2;
    }

    public final boolean h(int i) {
        List<WriteVoteItemData> list = this.f22610b;
        return list != null && list.size() < 20 && i == this.f22610b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            String text = this.f22610b.get(i).getText();
            eVar.f22620a.setHint(String.format(this.f22609a.getString(R.string.write_vote_item), Integer.valueOf(i + 1)));
            eVar.f22620a.setGravity(19);
            if (i < this.f22610b.size() - 1) {
                eVar.f22620a.setImeOptions(5);
            } else {
                eVar.f22620a.setImeOptions(1);
            }
            ImageView imageView = eVar.f22621b;
            if (this.f22610b.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new b(i));
            eVar.b(i);
            if (!StringUtils.isNull(text)) {
                eVar.f22620a.setText(text);
            } else {
                eVar.f22620a.setText("");
            }
            if (this.f22611c && i == this.f22610b.size() - 1) {
                eVar.f22620a.requestFocus();
                this.f22611c = false;
            }
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            dVar.f22617a.setText(String.format(this.f22609a.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.f22610b.size())));
            dVar.f22619c.setOnClickListener(new c());
        }
        f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new e(this, LayoutInflater.from(this.f22609a.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
        }
        return new d(this, LayoutInflater.from(this.f22609a.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
    }

    public void setData(List<WriteVoteItemData> list) {
        this.f22610b = list;
        notifyDataSetChanged();
    }
}
