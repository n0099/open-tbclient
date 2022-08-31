package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class uz8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rl4> a;
    public String b;
    public BaseFragmentActivity c;
    public int d;
    public LayoutInflater e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public ImageView c;

        public b(uz8 uz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(uz8 uz8Var, a aVar) {
            this(uz8Var);
        }
    }

    public uz8(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = baseFragmentActivity;
        this.e = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.d = ri.k(this.c.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public rl4 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? (rl4) ListUtils.getItem(this.a, i) : (rl4) invokeI.objValue;
    }

    public void b(List<rl4> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.a = list;
            this.b = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            if (view2 != null && (view2.getTag() instanceof b)) {
                bVar = (b) view2.getTag();
            } else {
                view2 = this.e.inflate(R.layout.obfuscated_res_0x7f0d0116, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f8d);
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f9f);
                bVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f75);
                bVar.a.setGifIconSupport(false);
                bVar.a.setLongIconSupport(false);
                view2.setTag(bVar);
            }
            rl4 item = getItem(i);
            if (item == null) {
                view2.setVisibility(4);
                return view2;
            }
            view2.setVisibility(0);
            if (!TextUtils.isEmpty(item.g())) {
                String t = ri.t(bVar.b.getPaint(), item.g(), this.d);
                bVar.b.setText(t + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                bVar.b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.b)) {
                bVar.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809db, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                bVar.c.setVisibility(0);
            } else {
                bVar.c.setVisibility(8);
            }
            MediaFileInfo f = item.f();
            if (f instanceof VideoFileInfo) {
                bVar.a.K(((VideoFileInfo) f).videoPath, 37, false);
            } else if (f instanceof ImageFileInfo) {
                bVar.a.K(((ImageFileInfo) f).getFilePath(), 35, false);
            }
            SkinManager.setViewTextColor(bVar.b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
