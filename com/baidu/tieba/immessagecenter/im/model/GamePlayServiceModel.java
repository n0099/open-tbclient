package com.baidu.tieba.immessagecenter.im.model;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.GamePlayServiceData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.n95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import org.json.JSONObject;
@Keep
/* loaded from: classes6.dex */
public class GamePlayServiceModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREFIX = "GamePlayService_";
    public transient /* synthetic */ FieldHolder $fh;
    public final Gson mGson;
    public b mPostAsyncTask;

    /* loaded from: classes6.dex */
    public interface a {
        void a(GamePlayServiceData gamePlayServiceData);
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile NetWork a;
        public String b;
        public a c;
        public final /* synthetic */ GamePlayServiceModel d;

        public b(GamePlayServiceModel gamePlayServiceModel, String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gamePlayServiceModel, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = gamePlayServiceModel;
            this.a = null;
            this.b = str;
            this.c = aVar;
            this.a = new NetWork("https://peiwan.baidu.com/peiwan/api/god/identity");
            this.a.addPostData(TbEnum.ParamKey.GID, str);
            this.a.setNeedBdussForGet(true);
            this.a.getNetContext().getRequest().mIsNeedTbs = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                try {
                    String netString = this.a.getNetString();
                    if (this.a.getNetContext().getResponse().isRequestSuccess() && netString != null) {
                        return netString;
                    }
                    return "";
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a != null) {
                    this.a.cancelNetConnect();
                    this.a = null;
                }
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.d.parseNetString(this.b, str, this.c);
            }
        }
    }

    public GamePlayServiceModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGson = new Gson();
    }

    public void release() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bVar = this.mPostAsyncTask) != null) {
            bVar.cancel();
            this.mPostAsyncTask = null;
        }
    }

    private GamePlayServiceData getGamePlayServiceData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            GamePlayServiceData gamePlayServiceData = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                if (this.mGson != null) {
                    gamePlayServiceData = (GamePlayServiceData) this.mGson.fromJson(str, (Class<Object>) GamePlayServiceData.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (gamePlayServiceData == null) {
                return new GamePlayServiceData(str);
            }
            return gamePlayServiceData;
        }
        return (GamePlayServiceData) invokeL.objValue;
    }

    private String loadGodInfoFromLocal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            n95 m = n95.m();
            return m.s(PREFIX + str, "");
        }
        return (String) invokeL.objValue;
    }

    private void loadGodInfoFromServer(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, aVar) == null) {
            b bVar = new b(this, str, aVar);
            this.mPostAsyncTask = bVar;
            bVar.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseNetString(String str, String str2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, str, str2, aVar) == null) {
            try {
                GamePlayServiceData gamePlayServiceData = getGamePlayServiceData(new JSONObject(str2).optString("data"));
                if (gamePlayServiceData != null) {
                    gamePlayServiceData.setSaveTime(System.currentTimeMillis());
                }
                saveGodInfoToLocal(str, gamePlayServiceData);
                if (aVar != null) {
                    aVar.a(gamePlayServiceData);
                }
            } catch (Exception e) {
                e.printStackTrace();
                aVar.a(null);
            }
        }
    }

    private void saveGodInfoToLocal(String str, GamePlayServiceData gamePlayServiceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, str, gamePlayServiceData) == null) {
            if (gamePlayServiceData == null) {
                n95 m = n95.m();
                m.B(PREFIX + str, "");
                return;
            }
            n95 m2 = n95.m();
            m2.B(PREFIX + str, new Gson().toJson(gamePlayServiceData));
        }
    }

    public void loadGodInfo(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) {
            GamePlayServiceData gamePlayServiceData = getGamePlayServiceData(loadGodInfoFromLocal(str));
            if (gamePlayServiceData == null) {
                loadGodInfoFromServer(str, aVar);
            } else if (System.currentTimeMillis() - gamePlayServiceData.getSaveTime() > gamePlayServiceData.getExpires() * 1000) {
                loadGodInfoFromServer(str, aVar);
            } else {
                aVar.a(gamePlayServiceData);
            }
        }
    }
}
