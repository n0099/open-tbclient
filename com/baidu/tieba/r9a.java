package com.baidu.tieba;

import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.q9a;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public WriteImageGridView b;
    public WriteImagesInfo c;
    public q9a d;
    public wh5 e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public PostPrefixData k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public b p;
    public q9a.f q;

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public class a implements q9a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r9a a;

        public a(r9a r9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r9aVar;
        }

        @Override // com.baidu.tieba.q9a.f
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.c == null) {
                return;
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.a.getPageActivity(), this.a.c.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.a.g);
            albumFloatActivityConfig.getIntent().putExtra("from", this.a.f);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanSelectOnlyVideo(false);
            albumFloatActivityConfig.setCanEditImage(false);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.a.h;
            antiData.setIfVoice(this.a.m);
            albumFloatActivityConfig.setStatisticFrom(this.a.l);
            albumFloatActivityConfig.setExtraData(antiData, this.a.k, this.a.i, this.a.j);
            albumFloatActivityConfig.setFromWrite(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }

        @Override // com.baidu.tieba.q9a.f
        public void b(int i) {
            int count;
            ImageFileInfo imageInfoAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.a.c != null && (count = ListUtils.getCount(this.a.c.getChosedFiles())) != 0 && i >= 0 && i < count && (imageInfoAt = this.a.c.getImageInfoAt(i)) != null && imageInfoAt.getImageType() != 1) {
                this.a.a.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.a.getPageActivity(), 12012, this.a.c, i)));
            }
        }

        @Override // com.baidu.tieba.q9a.f
        public void c(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.a.c != null && this.a.c.getChosedFiles() != null && i >= 0 && i < this.a.c.getChosedFiles().size()) {
                ImageFileInfo remove = this.a.c.getChosedFiles().remove(i);
                if (remove.isTempFile()) {
                    ac.f().a(new DiskFileOperate(remove.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
                r9a r9aVar = this.a;
                r9aVar.d.g(r9aVar.c);
                this.a.d.notifyDataSetChanged();
                if (ListUtils.isEmpty(this.a.c.getChosedFiles()) && this.a.a.getOrignalPage() != null) {
                    if (this.a.p != null) {
                        this.a.p.b();
                    }
                    if (!this.a.n) {
                        this.a.b.setVisibility(8);
                    }
                }
                if (this.a.p != null) {
                    this.a.p.a();
                }
            }
        }
    }

    public r9a(TbPageContext<?> tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new wh5();
        this.f = "write";
        this.g = "";
        this.h = null;
        this.n = false;
        this.q = new a(this);
        this.a = tbPageContext;
        this.b = (WriteImageGridView) view2.findViewById(R.id.obfuscated_res_0x7f092950);
        q9a q9aVar = new q9a(view2.getContext(), this.e, null, this.q);
        this.d = q9aVar;
        this.b.setAdapter((ListAdapter) q9aVar);
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.n = z;
            this.d.f(z);
        }
    }

    public void r(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.d.h(z);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.d.i(z);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.b();
        }
    }

    public GridView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (GridView) invokeV.objValue;
    }

    public void q(String str, String str2, String str3, PostPrefixData postPrefixData, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, postPrefixData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.h = str;
            this.i = str2;
            this.j = str3;
            this.k = postPrefixData;
            this.l = i;
            this.m = z;
        }
    }

    public void u(WriteImagesInfo writeImagesInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, writeImagesInfo, str, str2) == null) {
            this.f = str;
            this.g = str2;
            this.c = writeImagesInfo;
            this.d.g(writeImagesInfo);
            this.d.notifyDataSetChanged();
            v();
        }
    }

    public final void v() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.n) {
                this.b.setVisibility(0);
            } else if (!this.o && (writeImagesInfo = this.c) != null && writeImagesInfo.getChosedFiles() != null) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
        }
    }
}
