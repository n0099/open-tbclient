package com.baidu.tieba.video.editvideo.model;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.bp8;
import com.repackage.hq8;
import com.repackage.iq8;
import com.repackage.ji;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SelectMusicModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bp8 a;
    public TbPageContext b;
    public final HttpMessageListener c;

    /* loaded from: classes4.dex */
    public static class VideoSugMusicResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<MusicData> musicDatas;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoSugMusicResponseMessage(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
                int statusCode = getStatusCode();
                int error = getError();
                if (statusCode == 200 && error == 0 && jSONObject != null) {
                    String optString = jSONObject.optString("data");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    String optString2 = new JSONObject(optString).optString("music_list");
                    if (TextUtils.isEmpty(optString2)) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray(optString2);
                    this.musicDatas = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        MusicData musicData = (MusicData) OrmObject.objectWithJsonStr(jSONArray.optString(i2), MusicData.class);
                        if (musicData != null) {
                            this.musicDatas.add(musicData);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Integer, iq8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SelectMusicModel e;

        public a(SelectMusicModel selectMusicModel, String str, boolean z, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectMusicModel, str, Boolean.valueOf(z), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = selectMusicModel;
            this.a = str;
            this.b = z;
            this.c = str2;
            this.d = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public iq8 doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (TextUtils.isEmpty(this.a) && !this.b) {
                    return hq8.e().g(this.c, this.d);
                }
                return hq8.e().h(this.c, this.a, this.d, this.b);
            }
            return (iq8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(iq8 iq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iq8Var) == null) {
                super.onPostExecute(iq8Var);
                if (iq8Var == null || iq8Var.a != 0) {
                    this.e.a.onSaveMusicVideo(null, iq8Var.a, iq8Var.b);
                } else {
                    this.e.a.onSaveMusicVideo(this.d, -4399, "");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectMusicModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SelectMusicModel selectMusicModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectMusicModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectMusicModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003366 && (httpResponsedMessage instanceof VideoSugMusicResponseMessage)) {
                VideoSugMusicResponseMessage videoSugMusicResponseMessage = (VideoSugMusicResponseMessage) httpResponsedMessage;
                if (videoSugMusicResponseMessage.musicDatas == null) {
                    return;
                }
                this.a.a.setMusicData(videoSugMusicResponseMessage.musicDatas);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectMusicModel(TbPageContext tbPageContext, bp8 bp8Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bp8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new b(this, CmdConfigHttp.CMD_VIDEO_SUG_MUSIC);
        this.b = tbPageContext;
        this.a = bp8Var;
        A();
        this.c.setTag(getUniqueId());
        this.c.setSelfListener(true);
        registerListener(this.c);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC, TbConfig.SERVER_ADDRESS + "c/f/video/music");
            tbHttpMessageTask.setResponsedClass(VideoSugMusicResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void B(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            if ((z && TextUtils.isEmpty(str2)) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
                return;
            }
            new a(this, str2, z, str, str3).execute(new Void[0]);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!ji.z()) {
                this.b.showToast(R.string.obfuscated_res_0x7f0f0c6c);
            } else {
                sendMessage(new HttpMessage(CmdConfigHttp.CMD_VIDEO_SUG_MUSIC));
            }
        }
    }
}
