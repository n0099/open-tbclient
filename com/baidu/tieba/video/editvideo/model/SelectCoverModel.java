package com.baidu.tieba.video.editvideo.model;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.p.j;
import d.a.s0.x1.g;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SelectCoverModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.v3.h.a f21519e;

    /* renamed from: f  reason: collision with root package name */
    public d f21520f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f21521g;

    /* renamed from: h  reason: collision with root package name */
    public g f21522h;

    /* renamed from: i  reason: collision with root package name */
    public final HttpMessageListener f21523i;
    public final HttpMessageListener j;

    /* loaded from: classes5.dex */
    public static class VideoCheckUegResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic = null;
        public static String STATUS_FAIL = "2";
        public static String STATUS_OK = "1";
        public transient /* synthetic */ FieldHolder $fh;
        public String msg;
        public String status;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-994434385, "Lcom/baidu/tieba/video/editvideo/model/SelectCoverModel$VideoCheckUegResponseMessage;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-994434385, "Lcom/baidu/tieba/video/editvideo/model/SelectCoverModel$VideoCheckUegResponseMessage;");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoCheckUegResponseMessage(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
                int statusCode = getStatusCode();
                int error = getError();
                if (statusCode == 200 && error == 0 && jSONObject != null) {
                    String optString = jSONObject.optString("data");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(optString);
                    this.status = jSONObject2.optString("status");
                    this.msg = jSONObject2.optString("words");
                }
            }
        }

        public String getMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msg : (String) invokeV.objValue;
        }

        public String getStatus() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.status : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class VideoPendantResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<PendantData> pendantDatas;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoPendantResponseMessage(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
                int statusCode = getStatusCode();
                int error = getError();
                if (statusCode == 200 && error == 0 && jSONObject != null) {
                    String optString = jSONObject.optString("data");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    String optString2 = new JSONObject(optString).optString("list");
                    if (TextUtils.isEmpty(optString2)) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray(optString2);
                    this.pendantDatas = new ArrayList();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        PendantData pendantData = (PendantData) OrmObject.objectWithJsonStr(jSONArray.optString(i3), PendantData.class);
                        if (pendantData != null) {
                            pendantData.w();
                            this.pendantDatas.add(pendantData);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectCoverModel f21524a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectCoverModel selectCoverModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectCoverModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21524a = selectCoverModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003356 && (httpResponsedMessage instanceof VideoCheckUegResponseMessage)) {
                VideoCheckUegResponseMessage videoCheckUegResponseMessage = (VideoCheckUegResponseMessage) httpResponsedMessage;
                String status = videoCheckUegResponseMessage.getStatus();
                if (VideoCheckUegResponseMessage.STATUS_OK.equals(status)) {
                    this.f21524a.f21519e.onCheckUegSuccess();
                } else if (VideoCheckUegResponseMessage.STATUS_FAIL.equals(status)) {
                    String msg = videoCheckUegResponseMessage.getMsg();
                    if (TextUtils.isEmpty(msg)) {
                        msg = TbadkCoreApplication.getInst().getResources().getString(R.string.video_ueg_fail);
                    }
                    this.f21524a.f21519e.onCheckUegFail(msg);
                } else {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.video_fail);
                    }
                    this.f21524a.f21519e.onCheckUegFail(errorString);
                    if (this.f21524a.f21522h != null) {
                        this.f21524a.f21522h.a(201, errorString);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectCoverModel f21525a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SelectCoverModel selectCoverModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectCoverModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21525a = selectCoverModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003377 && (httpResponsedMessage instanceof VideoPendantResponseMessage)) {
                VideoPendantResponseMessage videoPendantResponseMessage = (VideoPendantResponseMessage) httpResponsedMessage;
                if (videoPendantResponseMessage.pendantDatas == null) {
                    return;
                }
                this.f21525a.f21519e.setPendantData(videoPendantResponseMessage.pendantDatas);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f21526a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21527b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SelectCoverModel f21528c;

        public c(SelectCoverModel selectCoverModel, Bitmap bitmap, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectCoverModel, bitmap, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21528c = selectCoverModel;
            this.f21526a = bitmap;
            this.f21527b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                File B = this.f21528c.B(this.f21526a, this.f21527b);
                this.f21526a.recycle();
                return B.getAbsolutePath();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((c) str);
                this.f21528c.f21519e.onSaveCover(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f21529a;

        /* renamed from: b  reason: collision with root package name */
        public int f21530b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SelectCoverModel f21531c;

        public d(SelectCoverModel selectCoverModel, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectCoverModel, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21531c = selectCoverModel;
            this.f21529a = str;
            this.f21530b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                Bitmap bitmap = null;
                if (TextUtils.isEmpty(this.f21529a)) {
                    return null;
                }
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.f21529a);
                    bitmap = mediaMetadataRetriever.getFrameAtTime(this.f21530b * 1000);
                    mediaMetadataRetriever.release();
                    return bitmap;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (this.f21531c.f21522h != null) {
                        this.f21531c.f21522h.a(203, d.a.s0.x1.a.a(e2));
                        return bitmap;
                    }
                    return bitmap;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                super.onPostExecute((d) bitmap);
                this.f21531c.f21519e.onGetCoverBitmap(bitmap);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectCoverModel(TbPageContext tbPageContext, d.a.s0.v3.h.a aVar, g gVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21523i = new a(this, CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
        this.j = new b(this, CmdConfigHttp.CMD_VIDEO_COVER_PENDANT);
        this.f21521g = tbPageContext;
        this.f21519e = aVar;
        this.f21522h = gVar;
        registerTask();
        this.f21523i.setTag(getUniqueId());
        this.f21523i.setSelfListener(true);
        registerListener(this.f21523i);
        this.j.setTag(getUniqueId());
        this.j.setSelfListener(true);
        registerListener(this.j);
    }

    public void A(Bitmap bitmap, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bitmap, str) == null) || bitmap == null || TextUtils.isEmpty(str)) {
            return;
        }
        new c(this, bitmap, str).execute(new Void[0]);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0041 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0043 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.graphics.Bitmap, java.lang.Object] */
    public File B(Bitmap bitmap, String str) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        ?? r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, str)) == null) {
            BufferedOutputStream bufferedOutputStream2 = null;
            if (bitmap == 0 || TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Exception e2) {
                e = e2;
                r2 = 0;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
            try {
                r2 = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, r2);
                    bufferedOutputStream.write(r2.toByteArray());
                    d.a.c.e.m.a.d(r2);
                    d.a.c.e.m.a.d(bufferedOutputStream);
                } catch (Exception e3) {
                    e = e3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    r2 = r2;
                    try {
                        e.printStackTrace();
                        if (this.f21522h != null) {
                            this.f21522h.a(202, d.a.s0.x1.a.a(e));
                        }
                        d.a.c.e.m.a.d(r2);
                        d.a.c.e.m.a.d(bufferedOutputStream2);
                        return file;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedOutputStream2 = r2;
                        d.a.c.e.m.a.d(bufferedOutputStream2);
                        d.a.c.e.m.a.d(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = r2;
                    d.a.c.e.m.a.d(bufferedOutputStream2);
                    d.a.c.e.m.a.d(bufferedOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                r2 = 0;
            } catch (Throwable th4) {
                th = th4;
                d.a.c.e.m.a.d(bufferedOutputStream2);
                d.a.c.e.m.a.d(bufferedOutputStream);
                throw th;
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public void C(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            d dVar = new d(this, str, i2);
            this.f21520f = dVar;
            dVar.execute(new Void[0]);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MessageManager.getInstance().unRegisterListener(this.f21523i);
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
            d dVar = this.f21520f;
            if (dVar != null) {
                dVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_TEXT_UEG, TbConfig.SERVER_ADDRESS + "c/f/video/next");
            tbHttpMessageTask.setResponsedClass(VideoCheckUegResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT, TbConfig.SERVER_ADDRESS + "c/f/video/pendant");
            tbHttpMessageTask2.setResponsedClass(VideoPendantResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_TEXT_UEG);
            httpMessage.addParam("text", str);
            sendMessage(httpMessage);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!j.z()) {
                this.f21521g.showToast(R.string.no_network);
            } else {
                sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_COVER_PENDANT));
            }
        }
    }
}
