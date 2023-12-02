package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.personExtra.PersonBarActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class x9a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonBarActivity a;
    public w9a b;
    public ArrayList<ForumData> c;
    public boolean d;
    public View.OnClickListener e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public View.OnClickListener j;
    public String k;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public TextView b;
        public StringBuffer c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public Button j;
        public ImageView k;
        public ImageView l;
        public ImageView m;

        public b(x9a x9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(x9a x9aVar, a aVar) {
            this(x9aVar);
        }
    }

    public x9a(PersonBarActivity personBarActivity, w9a w9aVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personBarActivity, w9aVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = false;
        this.e = null;
        this.f = false;
        this.g = true;
        this.h = false;
        this.i = true;
        this.a = personBarActivity;
        this.b = w9aVar;
        this.g = z;
        this.h = z2;
        this.i = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
    }

    public final void a(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (skinType == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(view2);
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.d = z;
            notifyDataSetChanged();
        }
    }

    public void g(ArrayList<ForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.c = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ArrayList<ForumData> arrayList = this.c;
            if (arrayList == null || i < 0 || i >= arrayList.size()) {
                return null;
            }
            return this.c.get(i);
        }
        return invokeI.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.k = str;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (this.f) {
                return false;
            }
            return super.isEnabled(i);
        }
        return invokeI.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f = false;
            ArrayList<ForumData> arrayList = this.c;
            if (arrayList == null || arrayList.size() == 0) {
                this.f = true;
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f) {
                return 1;
            }
            ArrayList<ForumData> arrayList = this.c;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            try {
                if (view2 == null) {
                    view2 = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0293, (ViewGroup) null);
                    bVar = new b(this, null);
                    BarImageView barImageView = (BarImageView) view2.findViewById(R.id.forum_avatar);
                    bVar.a = barImageView;
                    barImageView.setGifIconSupport(false);
                    bVar.a.setRadius(BdUtilHelper.getDimens(this.a, R.dimen.tbds10));
                    bVar.a.setConrers(15);
                    bVar.a.setPlaceHolder(2);
                    bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091993);
                    bVar.c = new StringBuffer(10);
                    bVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908b7);
                    bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908b8);
                    bVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b05);
                    bVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b08);
                    bVar.j = (Button) view2.findViewById(R.id.obfuscated_res_0x7f091226);
                    bVar.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908b9);
                    bVar.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091203);
                    bVar.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091261);
                    ImageView imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090938);
                    bVar.l = imageView;
                    imageView.setVisibility(0);
                    bVar.m = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091258);
                    view2.setTag(bVar);
                } else {
                    bVar = (b) view2.getTag();
                }
                if (this.f) {
                    bVar.d.setVisibility(8);
                    bVar.j.setVisibility(8);
                    bVar.b.setVisibility(8);
                    bVar.a.setVisibility(8);
                    bVar.e.setVisibility(8);
                    bVar.i.setVisibility(8);
                    bVar.g.setVisibility(8);
                    bVar.f.setVisibility(8);
                    bVar.h.setVisibility(8);
                    bVar.k.setVisibility(8);
                    bVar.l.setVisibility(8);
                } else {
                    bVar.b.setVisibility(0);
                    bVar.a.setVisibility(0);
                    if (this.g) {
                        bVar.d.setVisibility(8);
                        bVar.e.setVisibility(8);
                        bVar.i.setVisibility(0);
                        bVar.g.setVisibility(0);
                        bVar.f.setVisibility(0);
                        bVar.h.setVisibility(8);
                        bVar.l.setVisibility(0);
                    } else {
                        bVar.d.setVisibility(8);
                        bVar.e.setVisibility(8);
                        bVar.i.setVisibility(8);
                        bVar.g.setVisibility(8);
                        bVar.f.setVisibility(0);
                        bVar.h.setVisibility(0);
                        bVar.l.setVisibility(0);
                    }
                }
                if (this.c != null && i >= 0 && i < this.c.size() && (forumData = this.c.get(i)) != null) {
                    String image_url = forumData.getImage_url();
                    bVar.a.setTag(image_url);
                    bVar.a.setImageDrawable(null);
                    bVar.a.startLoad(image_url, 10, false);
                    bVar.c.delete(0, bVar.c.length());
                    bVar.c.append(forumData.getName());
                    bVar.c.append(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f078f));
                    bVar.b.setText(bVar.c);
                    if (this.g) {
                        SkinManager.setImageResource(bVar.f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.i.setText(String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f143a), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                        bVar.j.setOnClickListener(this.e);
                        bVar.j.setTag(Integer.valueOf(i));
                        if (i < this.b.k()) {
                            bVar.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                            if (!this.h && this.i) {
                                bVar.k.setVisibility(0);
                                bVar.k.setTag(Integer.valueOf(i));
                            }
                        } else {
                            bVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                            bVar.k.setVisibility(8);
                        }
                        bVar.k.setOnClickListener(this.j);
                        bVar.m.setVisibility(8);
                        if (this.h && this.a.S1() == 23011 && !TextUtils.isEmpty(forumData.getId()) && forumData.getId().equals(this.k)) {
                            bVar.m.setVisibility(0);
                        }
                    } else {
                        if ((this.a.x1() == 0 && i < this.b.k()) || (this.a.x1() == 1 && i < this.b.g())) {
                            bVar.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_v), (Drawable) null);
                        } else {
                            bVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        }
                        if (this.a.x1() == 1) {
                            bVar.f.setVisibility(8);
                        }
                        bVar.k.setVisibility(8);
                        SkinManager.setImageResource(bVar.f, BitmapHelper.getSmallGradeResourceIdNew(forumData.getUser_level()));
                        bVar.h.setText(forumData.getSlogan());
                    }
                    if (this.d) {
                        bVar.j.setVisibility(0);
                        bVar.k.setVisibility(8);
                    } else {
                        bVar.j.setVisibility(8);
                        if (i < this.b.k() && this.g && !this.h && this.i) {
                            bVar.k.setVisibility(0);
                        } else {
                            bVar.k.setVisibility(8);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            a(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
