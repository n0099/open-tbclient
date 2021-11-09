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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.l;
import b.a.q0.d1.m0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56160a;

    /* renamed from: b  reason: collision with root package name */
    public List<WriteVoteItemData> f56161b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56162c;

    /* renamed from: d  reason: collision with root package name */
    public f f56163d;

    /* renamed from: e  reason: collision with root package name */
    public TextView.OnEditorActionListener f56164e;

    /* loaded from: classes10.dex */
    public class a implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(WriteVoteViewAdapter writeVoteViewAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            View focusSearch;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 != 5 || (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) == null) {
                    return true;
                }
                focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f56165e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f56166f;

        public b(WriteVoteViewAdapter writeVoteViewAdapter, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56166f = writeVoteViewAdapter;
            this.f56165e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f56166f.f56163d == null) {
                return;
            }
            this.f56166f.f56163d.a(this.f56165e);
        }
    }

    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f56167e;

        public c(WriteVoteViewAdapter writeVoteViewAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56167e = writeVoteViewAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f56167e.f56163d == null) {
                return;
            }
            this.f56167e.f56163d.b();
            this.f56167e.f56162c = true;
        }
    }

    /* loaded from: classes10.dex */
    public class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f56168a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f56169b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f56170c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56168a = (TextView) view.findViewById(R.id.vote_add_item);
            this.f56169b = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.f56170c = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* loaded from: classes10.dex */
    public class e extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EditText f56171a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f56172b;

        /* renamed from: c  reason: collision with root package name */
        public g f56173c;

        /* loaded from: classes10.dex */
        public class a implements View.OnFocusChangeListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f56174e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56174e = eVar;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                    if (z) {
                        e eVar = this.f56174e;
                        eVar.f56171a.addTextChangedListener(eVar.f56173c);
                        return;
                    }
                    e eVar2 = this.f56174e;
                    eVar2.f56171a.removeTextChangedListener(eVar2.f56173c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56171a = (EditText) view.findViewById(R.id.vote_item);
            this.f56172b = (ImageView) view.findViewById(R.id.img_delete);
            this.f56173c = new g(writeVoteViewAdapter, this);
            this.f56171a.setOnEditorActionListener(writeVoteViewAdapter.f56164e);
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f56173c.a(i2);
                this.f56171a.setOnFocusChangeListener(new a(this));
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(WriteVoteItemData writeVoteItemData, int i2);
    }

    /* loaded from: classes10.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final e f56175e;

        /* renamed from: f  reason: collision with root package name */
        public int f56176f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f56177g;

        public g(WriteVoteViewAdapter writeVoteViewAdapter, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56177g = writeVoteViewAdapter;
            this.f56175e = eVar;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f56176f = i2;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                obj = "";
            }
            String replace = obj.replace(" ", "");
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            writeVoteItemData.setId(this.f56176f + 1);
            if (m0.d(replace) > 28) {
                this.f56177g.f56160a.showToast(String.format(this.f56177g.f56160a.getString(R.string.write_vote_toast), 14));
            }
            String m = m0.m(replace, 28);
            if (!m.equals(editable.toString())) {
                this.f56175e.f56171a.setText(m);
                this.f56175e.f56171a.setSelection(m.length());
            }
            writeVoteItemData.setText(m);
            this.f56177g.f56163d.c(writeVoteItemData, this.f56176f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048579, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56162c = false;
        this.f56164e = new a(this);
        this.f56160a = tbPageContext;
    }

    public final boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<WriteVoteItemData> list = this.f56161b;
            return list != null && list.size() < 20 && i2 == this.f56161b.size();
        }
        return invokeI.booleanValue;
    }

    public List<WriteVoteItemData> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56161b : (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<WriteVoteItemData> list = this.f56161b;
            if (list == null) {
                return 0;
            }
            if (list.size() < 20) {
                return this.f56161b.size() + 1;
            }
            return 20;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? !d(i2) ? 1 : 2 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) {
            if (viewHolder instanceof e) {
                e eVar = (e) viewHolder;
                String text = this.f56161b.get(i2).getText();
                eVar.f56171a.setHint(String.format(this.f56160a.getString(R.string.write_vote_item), Integer.valueOf(i2 + 1)));
                eVar.f56171a.setGravity(19);
                if (i2 < this.f56161b.size() - 1) {
                    eVar.f56171a.setImeOptions(5);
                } else {
                    eVar.f56171a.setImeOptions(1);
                }
                ImageView imageView = eVar.f56172b;
                if (this.f56161b.size() > 2) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                imageView.setOnClickListener(new b(this, i2));
                eVar.b(i2);
                if (!StringUtils.isNull(text)) {
                    eVar.f56171a.setText(text);
                } else {
                    eVar.f56171a.setText("");
                }
                if (this.f56162c && i2 == this.f56161b.size() - 1) {
                    eVar.f56171a.requestFocus();
                    this.f56162c = false;
                }
            } else if (viewHolder instanceof d) {
                d dVar = (d) viewHolder;
                dVar.f56168a.setText(String.format(this.f56160a.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.f56161b.size())));
                dVar.f56170c.setOnClickListener(new c(this));
            }
            onChangeSkinType(viewHolder);
        }
    }

    public void onChangeSkinType(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, viewHolder) == null) || viewHolder == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f56160a.getResources().getDimension(R.dimen.tbds10));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
        gradientDrawable.setStroke(l.g(this.f56160a.getPageActivity(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0603));
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            eVar.f56171a.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            eVar.f56171a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            eVar.f56171a.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(eVar.f56172b, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            SkinManager.setViewTextColor(dVar.f56168a, R.color.CAM_X0302);
            dVar.f56170c.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(dVar.f56169b, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            if (i2 == 1) {
                return new e(this, LayoutInflater.from(this.f56160a.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
            }
            return new d(this, LayoutInflater.from(this.f56160a.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(List<WriteVoteItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f56161b = list;
            notifyDataSetChanged();
        }
    }

    public void setOnVoteItemListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f56163d = fVar;
        }
    }
}
